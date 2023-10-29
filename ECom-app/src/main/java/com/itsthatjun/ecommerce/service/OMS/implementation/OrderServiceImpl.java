package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.github.pagehelper.PageHelper;
import com.itsthatjun.ecommerce.config.PaypalPaymentIntent;
import com.itsthatjun.ecommerce.config.PaypalPaymentMethod;
import com.itsthatjun.ecommerce.dto.OMS.OrderDetail;
import com.itsthatjun.ecommerce.dto.OMS.OrderParam;
import com.itsthatjun.ecommerce.exceptions.OMS.OrderException;
import com.itsthatjun.ecommerce.mbg.mapper.*;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.Messaging.OrderMessageService;
import com.itsthatjun.ecommerce.service.OMS.OrderService;
import com.itsthatjun.ecommerce.service.PMS.implementation.ProductServiceImpl;
import com.itsthatjun.ecommerce.service.PaypalService;
import com.itsthatjun.ecommerce.service.RedisServiceImpl;
import com.itsthatjun.ecommerce.service.SMS.implementation.CouponServiceImpl;
import com.itsthatjun.ecommerce.service.SMS.implementation.SalesServiceimpl;
import com.itsthatjun.ecommerce.service.UMS.MemberService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final String PAYPAL_PAYMENT_LINK = "https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token=";

    private final double SHIPPING_COST = 15;  // default shipping cost for order less than 50

    private final CouponServiceImpl couponService;

    private final ProductServiceImpl productService;        // TODO: update stock

    private final SalesServiceimpl salesServiceimpl;    // TODO: not used yet for when sales limit reached

    private final CartItemServiceImpl cartItemService;

    private final OrderMessageService messageService;

    private final PaypalService paypalService;

    private final OrdersMapper ordersMapper;

    private final OrderItemMapper orderItemMapper;

    private final OrderChangeHistoryMapper orderChangeHistoryMapper;

    private final ProductMapper productMapper;

    private final ProductSkuMapper stockMapper;

    private final RedisServiceImpl redisService;

    @Value("${redis.key.orderId}")
    private String REDIS_KEY_ORDER_ID;

    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Autowired
    public OrderServiceImpl(OrderMessageService messageService, CouponServiceImpl couponService, ProductServiceImpl productService,
                            SalesServiceimpl salesServiceimpl, CartItemServiceImpl cartItemService, PaypalService paypalService,
                            OrdersMapper ordersMapper, OrderItemMapper orderItemMapper, OrderChangeHistoryMapper orderChangeHistoryMapper,
                            ProductMapper productMapper, ProductSkuMapper stockMapper, RedisServiceImpl redisService) {
        this.messageService = messageService;
        this.couponService = couponService;
        this.productService = productService;
        this.salesServiceimpl = salesServiceimpl;
        this.cartItemService = cartItemService;
        this.paypalService = paypalService;
        this.ordersMapper = ordersMapper;
        this.orderItemMapper = orderItemMapper;
        this.orderChangeHistoryMapper = orderChangeHistoryMapper;
        this.productMapper = productMapper;
        this.stockMapper = stockMapper;
        this.redisService = redisService;
    }

    public OrderDetail getOrderDetail(String orderSn, int userId) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andOrderSnEqualTo(orderSn).andMemberIdEqualTo(userId);
        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);
        if (ordersList.isEmpty()) return null;
        Orders order = ordersMapper.selectByExample(ordersExample).get(0);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrders(order);

        return orderDetail;
    }

    @Override
    public List<Orders> list(int status, int pageNum, int pageSize, int userId) {
        PageHelper.startPage(pageNum, pageSize);
        OrdersExample ordersExample = new OrdersExample();
        // TODO: the status code. currently just return all
        ordersExample.createCriteria().andMemberIdEqualTo(userId).andStatusEqualTo(status);

        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);
        return ordersList;
    }

    @Override
    public Orders generateOrder(OrderParam orderParam, String successUrl, String cancelUrl, int userId) {
        String couponCode = orderParam.getCoupon();
        Address address = orderParam.getAddress();
        int payType = orderParam.getPayType();  // TODO: make a payType enum and change postman

        Orders newOrder = new Orders();
        newOrder.setPayType(payType);
        newOrder.setSourceType(1);  // TODO: add source type from request, web or mobile
        String orderSn = generateOrderSn(newOrder);

        List<OrderItem> orderItemList = new ArrayList<>();

        Map<String, Integer> skuQuantity = orderParam.getOrderProductSku(); // sku and quantity for order

        double orderTotal = 0;
        double couponDiscount = orderParam.getDiscountAmount();

        // verify the price again
        for (String skuCode: skuQuantity.keySet()) {
            int quantity = orderParam.getOrderProductSku().get(skuCode);

            // find the sku and product
            ProductSkuExample productSkuExample = new ProductSkuExample();
            productSkuExample.createCriteria().andSkuCodeEqualTo(skuCode);
            ProductSku sku = stockMapper.selectByExample(productSkuExample).get(0);

            ProductExample productExample = new ProductExample();
            productExample.createCriteria().andIdEqualTo(sku.getProductId());
            Product product = productMapper.selectByExample(productExample).get(0);

            OrderItem orderItem = new OrderItem();
            orderItem.setProductSkuId(sku.getId());
            orderItem.setProductId(product.getId());
            orderItem.setProductSkuCode(skuCode);
            orderItem.setProductName(product.getName());
            orderItem.setProductQuantity(quantity);
            orderItem.setRealAmount(sku.getPromotionPrice());

            orderTotal += sku.getPromotionPrice().doubleValue() * quantity;
            orderItemList.add(orderItem);
        }

        if (!hasStock(orderItemList)) throw new OrderException("Not enough stock, Unable to order");

        orderTotal = Math.round(orderTotal * 100.0) / 100.0;  // TODO: change back double to big decimal for more accuracy
        // and use.setScale(2, RoundingMode.CEILING);

        // verify price difference
        if (orderTotal != orderParam.getAmount()) throw new OrderException("Pricing error");

        lockStock(orderItemList);

        double checkedDiscount = couponService.checkDiscount(couponCode, userId);
        couponDiscount = couponDiscount == checkedDiscount ? checkedDiscount : 0;

        // check shipping cost, $50 or more get free shipping or $15
        // TODO: calculate shipping cost from UPS API, currently just fixed rate
        if (orderTotal < 50) orderTotal += SHIPPING_COST;

        orderTotal = orderTotal - couponDiscount;

        //newOrder.setPayType(payType);  // TODO: change data type to string in database

        newOrder.setOrderSn(orderSn);
        newOrder.setStatus(0);   // waiting for payment
        newOrder.setTotalAmount(BigDecimal.valueOf(orderTotal));
        newOrder.setMemberId(userId);

        newOrder.setReceiverName(address.getReceiverName());
        newOrder.setReceiverDetailAddress(address.getDetailAddress());

        newOrder.setCreatedAt(new Date());
        ordersMapper.insert(newOrder);

        int newOrderId = newOrder.getId();

        for (OrderItem item : orderItemList) {
            item.setOrderSn(orderSn);
            item.setOrderId(newOrderId);
            orderItemMapper.insert(item);
        }

        if (!couponCode.isEmpty()) couponService.updateUsedCoupon(couponCode, newOrderId, userId);

        // clear cart
        cartItemService.clearCartItem(userId);

        // scheduled order to be cancel if order not being paid with in time.
        messageService.sendDelayedCancelOrderMessage(orderSn);

        updateChangeLog(newOrderId, 0, "generate order","user");

        try {
            Payment payment = paypalService.createPayment(orderTotal, "USD", PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale, "payment description", cancelUrl, successUrl, orderSn);
            for(Links links : payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    String paymentURL = links.getHref();
                    String searchTerm = "token=";
                    int index = paymentURL.indexOf(searchTerm);
                    String paymentToken = paymentURL.substring(index + searchTerm.length());

                    // store payment token for later payment option
                    newOrder.setPaymentId(paymentToken);
                    ordersMapper.updateByPrimaryKeySelective(newOrder);

                    System.out.println("redirect:" + links.getHref());
                }
            }
        } catch (PayPalRESTException e) {
            LOG.error(e.getMessage());
        }
        return newOrder;
    }

    @Override
    public String getPaymentLink(String orderSn, int userId) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andOrderSnEqualTo(orderSn).andMemberIdEqualTo(userId).andStatusEqualTo(0);
        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);

        if (ordersList.isEmpty()) return "order serial number does not exist: " + orderSn;

        Orders orders = ordersList.get(0);

        String paymentToken = orders.getPaymentId();
        String paymentLink = PAYPAL_PAYMENT_LINK + paymentToken;

        return "redirect:" + paymentLink;
    }

    @Override
    public Orders paySuccess(String paymentId, String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);

            if (payment.getState().equals("approved")) {
                System.out.println("successful payment");

                Transaction transaction = payment.getTransactions().get(0);
                String saleId = transaction.getRelatedResources().get(0).getSale().getId();
                String orderSn = transaction.getCustom();

                // find and update the order, status, payment info
                OrdersExample ordersExample = new OrdersExample();
                ordersExample.createCriteria().andOrderSnEqualTo(orderSn);
                Orders foundOrder = ordersMapper.selectByExample(ordersExample).get(0);

                foundOrder.setStatus(1);  // waiting for payment 0 , fulfilling 1,
                foundOrder.setPaymentId(saleId);
                foundOrder.setPayerId(payerId);
                foundOrder.setPayAmount(foundOrder.getTotalAmount());

                int orderId = foundOrder.getId();
                Date currentDate = new Date();
                foundOrder.setPaymentTime(currentDate);
                foundOrder.setUpdatedAt(currentDate);

                ordersMapper.updateByPrimaryKey(foundOrder);

                OrderItemExample orderItemExample = new OrderItemExample();
                orderItemExample.createCriteria().andOrderSnEqualTo(orderSn);
                List<OrderItem> orderItemList = orderItemMapper.selectByExample(orderItemExample);

                Map<String, Integer> itemOrderQuantity = new HashMap<>();

                // update stock and free up locked stock
                for (OrderItem item: orderItemList) {
                    int quantityOrdered = item.getProductQuantity();

                    // find product and get current stock and update it
                    ProductExample productExample = new ProductExample();
                    productExample.createCriteria().andIdEqualTo(item.getProductId());
                    Product product = productMapper.selectByExample(productExample).get(0);

                    int currentStock = product.getStock();
                    product.setStock(currentStock - quantityOrdered);
                    productMapper.updateByPrimaryKey(product);

                    // update sku stock and free lock stock
                    ProductSkuExample skuExample = new ProductSkuExample();
                    skuExample.createCriteria().andSkuCodeEqualTo(item.getProductSkuCode()).andProductIdEqualTo(product.getId());
                    ProductSku productSku = stockMapper.selectByExample(skuExample).get(0);

                    currentStock = productSku.getStock();
                    productSku.setStock(currentStock - quantityOrdered);
                    productSku.setLockStock(productSku.getLockStock() - quantityOrdered);
                    stockMapper.updateByPrimaryKey(productSku);
                }
                // Generated order and success payment, decrease product stock, decrease sku stock and sku lock stock
                // sendProductStockUpdateMessage("product-out-0",new PmsProductOutEvent(PmsProductOutEvent.Type.UPDATE_PURCHASE_PAYMENT, orderSn, itemOrderQuantity));
                // sendSalesStockUpdateMessage("salesStock-out-0", new SmsSalesStockOutEvent(SmsSalesStockOutEvent.Type.UPDATE_PURCHASE_PAYMENT, orderSn, itemOrderQuantity));

                updateChangeLog(orderId, 1, "payment success","user");

                return foundOrder;
            }
        } catch (PayPalRESTException e) {
            LOG.error(e.getMessage());
        }
        throw new OrderException("Error payment after success URL");
    }

    @Override
    public void delayedCancelOrder(String orderSn) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andOrderSnEqualTo(orderSn);
        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);

        if (ordersList.isEmpty()) throw new RuntimeException("order serial number does not exist: " + orderSn);

        Orders newOrder = ordersList.get(0);

        // Order being paid, waiting for payment 0 , fulfilling(paid) 1
        if (newOrder.getStatus() == 1) return;

        newOrder.setUpdatedAt(new Date());
        newOrder.setStatus(5);
        ordersMapper.updateByPrimaryKeySelective(newOrder);

        int orderId = newOrder.getId();

        OrderItemExample orderItemExample = new OrderItemExample();
        orderItemExample.createCriteria().andOrderSnEqualTo(orderSn).andOrderIdEqualTo(orderId);
        List<OrderItem> orderItemList = orderItemMapper.selectByExample(orderItemExample);

        Map<String, Integer> itemOrderQuantity = new HashMap<>();

        // free up locked stock on local OMS
        for (OrderItem item : orderItemList) {
            int productId = item.getProductId();
            String skuCode = item.getProductSkuCode();
            int quantityNeeded = item.getProductQuantity();

            ProductSkuExample example = new ProductSkuExample();
            example.createCriteria().andProductIdEqualTo(productId).andSkuCodeEqualTo(skuCode);
            ProductSku sku = stockMapper.selectByExample(example).get(0);

            int itemStockLockNow = sku.getLockStock();
            sku.setLockStock(itemStockLockNow - quantityNeeded);
            stockMapper.updateByPrimaryKey(sku);

            itemOrderQuantity.put(skuCode, quantityNeeded);
        }

        // send stock update to PMS and SMS
        // sendProductStockUpdateMessage("product-out-0",new PmsProductOutEvent(PmsProductOutEvent.Type.UPDATE_FAIL_PAYMENT, orderSn, itemOrderQuantity));
        // sendSalesStockUpdateMessage("salesStock-out-0", new SmsSalesStockOutEvent(SmsSalesStockOutEvent.Type.UPDATE_FAIL_PAYMENT, orderSn, itemOrderQuantity));

        updateChangeLog(orderId, 5, "payment fail","user");
    }

    @Override
    public Orders cancelOrder(String orderSn, int userId) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andOrderSnEqualTo(orderSn).andMemberIdEqualTo(userId);
        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);

        // TODO: create OrderNotFoundException
        if (ordersList.isEmpty()) throw new RuntimeException("order not found with order serial number: " + orderSn);

        Orders foundOrder = ordersList.get(0);
        int orderId = foundOrder.getId();

        //  waiting for payment 0 , fulfilling 1,  send 2 , complete(received) 3, closed(out of return period) 4 , invalid 5
        int currentStatus = foundOrder.getStatus();

        if (currentStatus >= 2) {
            throw new OrderException("Order already send out, can not cancel");
        }

        // TODO :might add something like need admin approval after certain hours to cancel order
        OrderItemExample orderItemExample = new OrderItemExample();
        orderItemExample.createCriteria().andOrderSnEqualTo(orderSn);
        List<OrderItem> orderItemList = orderItemMapper.selectByExample(orderItemExample);

        Map<String, Integer> skuQuantity = new HashMap<>();

        // record order sku and quantity, and update OMS stock. free up stock.
        for (OrderItem orderItem : orderItemList) {
            String skuCode = orderItem.getProductSkuCode();
            int quantity = orderItem.getProductQuantity();
            skuQuantity.put(skuCode, quantity);

            // update OMS stock, increase product and sku stock. same as return.
            ProductSkuExample skuExample = new ProductSkuExample();
            skuExample.createCriteria().andSkuCodeEqualTo(skuCode);
            ProductSku sku = stockMapper.selectByExample(skuExample).get(0);

            // update sku stock
            int currentStock = sku.getStock();
            sku.setStock(currentStock + quantity);
            stockMapper.updateByPrimaryKeySelective(sku);

            // update stock product
            int productId = orderItem.getProductId();
            Product product = productMapper.selectByPrimaryKey(productId);
            currentStock = product.getStock();
            product.setStock(currentStock + quantity);
            productMapper.updateByPrimaryKeySelective(product);
        }

        foundOrder.setStatus(5);
        ordersMapper.updateByPrimaryKeySelective(foundOrder);

        updateChangeLog(orderId, 5, "Cancel order","user");

        return foundOrder;
    }

    @Override
    public void confirmReceiveOrder(int orderId) {
        // TODO: with spring stask to check from UPS/FedEx for package delivery update.
    }

    private String generateOrderSn(Orders newOrder) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ORDER_ID + date;
        Long increment = redisService.incr(key, 1);
        sb.append(date + increment);

        sb.append(String.format("%02d", newOrder.getSourceType()));
        sb.append(String.format("%02d", newOrder.getPayType()));
        String incrementStr = increment.toString();

        if (incrementStr.length() <= 6) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }

    private void lockStock(List<OrderItem> orderItemList) {
        for (OrderItem item : orderItemList) {
            int productId = item.getProductId();
            String skuCode = item.getProductSkuCode();
            int quantityNeeded = item.getProductQuantity();
            ProductSkuExample example = new ProductSkuExample();
            example.createCriteria().andProductIdEqualTo(productId).andSkuCodeEqualTo(skuCode);
            ProductSku itemStock = stockMapper.selectByExample(example).get(0);

            int itemStockNow = itemStock.getLockStock();

            itemStock.setLockStock(itemStockNow + quantityNeeded);
            stockMapper.updateByPrimaryKey(itemStock);
        }
    }

    private boolean hasStock(List<OrderItem> orderItemList) {
        for (OrderItem item : orderItemList) {
            int productId = item.getProductId();
            String skuCode = item.getProductSkuCode();
            int quantityNeeded = item.getProductQuantity();
            ProductSkuExample example = new ProductSkuExample();
            example.createCriteria().andProductIdEqualTo(productId).andSkuCodeEqualTo(skuCode);
            ProductSku itemStock = stockMapper.selectByExample(example).get(0);

            if (itemStock != null && itemStock.getStock() < (itemStock.getLockStock() + quantityNeeded)){
                return false;
            }
        }
        return true;
    }

    private void updateChangeLog(int orderId, int status, String note, String operator) {
        OrderChangeHistory changeLog = new OrderChangeHistory();
        changeLog.setOrderId(orderId);
        changeLog.setOrderStatus(status);
        changeLog.setUpdateAction("");  // TODO:
        changeLog.setOperator(operator);
        changeLog.setNote(note);
        changeLog.setCreatedAt(new Date());
        orderChangeHistoryMapper.insert(changeLog);
    }

    /*
    private void sendProductStockUpdateMessage(String bindingName, PmsProductOutEvent event) {
        LOG.debug("Sending a {} message to {}", event.getEventType(), bindingName);
        System.out.println("sending to binding: " + bindingName);
        Message message = MessageBuilder.withPayload(event)
                .setHeader("event-type", event.getEventType())
                .build();
        streamBridge.send(bindingName, message);
    }
     */
}
