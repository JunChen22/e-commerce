package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.itsthatjun.ecommerce.dao.OMS.ReturnDao;
import com.itsthatjun.ecommerce.dto.OMS.ReturnDetail;
import com.itsthatjun.ecommerce.dto.OMS.ReturnRequestDecision;
import com.itsthatjun.ecommerce.exceptions.OMS.ReturnRequestException;
import com.itsthatjun.ecommerce.mbg.mapper.*;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.OMS.ReturnOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReturnOrderServiceImpl implements ReturnOrderService {

    private static final Logger LOG = LoggerFactory.getLogger(ReturnOrderServiceImpl.class);

    private final ReturnRequestMapper returnRequestMapper;

    private final ReturnReasonPicturesMapper picturesMapper;

    private final ReturnItemMapper returnItemMapper;

    private final OrderItemMapper orderItemMapper;

    private final OrdersMapper ordersMapper;

    private final CompanyAddressMapper companyAddressMapper;

    private final ReturnLogMapper logMapper;

    private final ReturnDao returnDao;

    @Autowired
    public ReturnOrderServiceImpl(ReturnRequestMapper returnRequestMapper, ReturnReasonPicturesMapper picturesMapper,
                                  ReturnItemMapper returnItemMapper, OrderItemMapper orderItemMapper, OrdersMapper ordersMapper,
                                  CompanyAddressMapper companyAddressMapper, ReturnLogMapper logMapper, ReturnDao returnDao) {
        this.returnRequestMapper = returnRequestMapper;
        this.picturesMapper = picturesMapper;
        this.returnItemMapper = returnItemMapper;
        this.orderItemMapper = orderItemMapper;
        this.ordersMapper = ordersMapper;
        this.companyAddressMapper = companyAddressMapper;
        this.logMapper = logMapper;
        this.returnDao = returnDao;
    }

    // return status,  waiting to process 0 , returning(sending) 1, complete 2, rejected(not matching reason) 3
    @Override
    public List<ReturnRequest> getAllOpening() {
        ReturnRequestExample example = new ReturnRequestExample();
        example.createCriteria().andStatusEqualTo(0);

        List<ReturnRequest> orderReturnRequests = returnRequestMapper.selectByExample(example);
        return orderReturnRequests;
    }

    @Override
    public List<ReturnRequest> getAllReturning() {
        ReturnRequestExample example = new ReturnRequestExample();
        example.createCriteria().andStatusEqualTo(1);
        List<ReturnRequest> returningRequests = returnRequestMapper.selectByExample(example);

        return returningRequests;
    }

    @Override
    public List<ReturnRequest> getAllCompleted() {
        ReturnRequestExample example = new ReturnRequestExample();
        example.createCriteria().andStatusEqualTo(2);
        List<ReturnRequest> completedReturns = returnRequestMapper.selectByExample(example);

        return completedReturns;
    }

    @Override
    public List<ReturnRequest> getAllRejected() {
        ReturnRequestExample example = new ReturnRequestExample();
        example.createCriteria().andStatusEqualTo(3);
        List<ReturnRequest> rejectedRequests = returnRequestMapper.selectByExample(example);

        return rejectedRequests;
    }

    @Override
    public ReturnDetail getReturnDetail(String orderSn) {
        ReturnRequestExample example = new ReturnRequestExample();
        example.createCriteria().andOrderSnEqualTo(orderSn);

        List<ReturnRequest> returnRequest = returnRequestMapper.selectByExample(example);
        if (returnRequest.isEmpty())
            throw new ReturnRequestException("Order Return request for order serial number: " + orderSn + " does not exist");

        ReturnRequest returnOrderRequest = returnRequest.get(0);

        // get lsit of return item too

        // TODO: make a dao for this easier retrieve
        //   dao.getDetail(orderSn);
        ReturnItemExample orderReturnItemExample = new ReturnItemExample();

        ReturnDetail returnDetail = new ReturnDetail();

        returnDetail = returnDao.getDetail(orderSn);

        List<ReturnItem> returnItemList;
        List<ReturnReasonPictures> picturesList;

        return returnDetail;
    }

    // return status,  waiting to process 0 , returning(sending) 1, complete 2, rejected(not matching reason) 3
    @Override
    public ReturnRequest approveReturnRequest(ReturnRequestDecision returnRequestDecision, String operator) {

        ReturnRequest orderReturnRequest = returnRequestDecision.getReturnRequest();
        List<ReturnItem> returnItemList = returnRequestDecision.getReturnItemList();
        int companyAddressId = orderReturnRequest.getCompanyAddressId();
        String orderSn = orderReturnRequest.getOrderSn();

        // check price from their order
        double returnItemRefundAmount = 0;
        for (ReturnItem item: returnItemList) {
            OrderItemExample orderItemExample = new OrderItemExample();
            orderItemExample.createCriteria().andOrderSnEqualTo(orderSn);
            List<OrderItem> orderItemList = orderItemMapper.selectByExample(orderItemExample);

            if (orderItemList.isEmpty()) throw new RuntimeException("Return item not in order: " + item.getOrderSn());
            OrderItem orderItem = orderItemList.get(0);

            if (orderItem.getRealAmount() != item.getPurchasedPrice()) throw new RuntimeException("Error pricing with return item");

            int quantity = item.getQuantity();

            returnItemRefundAmount += item.getPurchasedPrice().doubleValue() * quantity;    // TODO: watch out for big decimal difference
        }

        if (returnItemRefundAmount != orderReturnRequest.getAskingAmount().doubleValue()) {
            throw new RuntimeException("Return order Request asking refund pricing error");
        }

        orderReturnRequest.setStatus(1);
        orderReturnRequest.setHandleOperator(operator);
        orderReturnRequest.setUpdatedAt(new Date());
        returnRequestMapper.updateByPrimaryKey(orderReturnRequest);

        ReturnLog returnUpdateLog = new ReturnLog();
        returnUpdateLog.setAction("Approve return Request request");
        returnUpdateLog.setOperator(operator);
        returnUpdateLog.setCreatedAt(new Date());
        logMapper.insert(returnUpdateLog);

        // generate return label
        // using companyAddressId to get address
        CompanyAddressExample companyAddressExample = new CompanyAddressExample();
        companyAddressExample.createCriteria().andIdEqualTo(companyAddressId);
        List<CompanyAddress> addressList = companyAddressMapper.selectByExample(companyAddressExample);

        if (addressList.isEmpty()) throw new RuntimeException("Company address is invalid with company address id :" + companyAddressId);
        CompanyAddress receivedLocation = addressList.get(0);

        // TODO: UPS to print label and send back to customer

        // TODO: send notification to maybe an email service to notify user
        return orderReturnRequest;
    }

    @Override
    public ReturnRequest rejectReturnRequest(ReturnRequestDecision returnRequestDecision, String reason, String operator) {
        ReturnRequest returnRequest = returnRequestDecision.getReturnRequest();
        returnRequest.setStatus(3);
        returnRequest.setHandleNote(reason);
        returnRequest.setHandleOperator(operator);
        returnRequest.setUpdatedAt(new Date());
        returnRequestMapper.updateByPrimaryKey(returnRequest);

        ReturnLog returnUpdateLog = new ReturnLog();
        returnUpdateLog.setAction("Rejected return Request request");
        returnUpdateLog.setOperator(operator);
        returnUpdateLog.setCreatedAt(new Date());
        logMapper.insert(returnUpdateLog);

        return returnRequest;
    }

    @Override
    public ReturnRequest completeReturnRequest(ReturnRequestDecision returnRequestDecision, String operator) {
        ReturnRequest returnRequest = returnRequestDecision.getReturnRequest();

        String orderSn = returnRequest.getOrderSn();
        int returnRequestId = returnRequest.getId();

        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andOrderSnEqualTo(orderSn);
        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);

        if (ordersList.isEmpty()) throw new ReturnRequestException("Order does not exist error");
        Orders foundOrder = ordersList.get(0);

        returnRequest.setStatus(2);
        returnRequest.setHandleOperator(operator);
        returnRequest.setUpdatedAt(new Date());
        returnRequestMapper.updateByPrimaryKey(returnRequest);

        ReturnLog returnUpdateLog = new ReturnLog();
        returnUpdateLog.setAction("Rejected return Request request");
        returnUpdateLog.setOperator(operator);
        returnUpdateLog.setCreatedAt(new Date());
        logMapper.insert(returnUpdateLog);

        ReturnItemExample returnItemExample = new ReturnItemExample();
        returnItemExample.createCriteria().andReturnRequestIdEqualTo(returnRequestId).andOrderSnEqualTo(orderSn);
        List<ReturnItem> returnedItemList = returnItemMapper.selectByExample(returnItemExample);

        // Get returned item sku and quantity for update SMS and PMS service.
        Map<String, Integer> skuQuantity = new HashMap<>();
        for (ReturnItem returnItem : returnedItemList) {
            String skuCode = returnItem.getProductSku();
            int quantity = returnItem.getQuantity();
            skuQuantity.put(skuCode, quantity);
        }

        //sendProductStockUpdateMessage("product-out-0", new PmsProductOutEvent(PmsProductOutEvent.Type.UPDATE_RETURN, orderSn, skuQuantity));
        //sendSalesStockUpdateMessage("salesStock-out-0", new SmsSalesStockOutEvent(SmsSalesStockOutEvent.Type.UPDATE_RETURN, orderSn, skuQuantity));

        // TODO: PayPal refund
        String saleId = foundOrder.getPaymentId();
        // RefundRequest refundRequest = new RefundRequest();
        // Refund refund = new Refund();

        return returnRequest;
    }
}
