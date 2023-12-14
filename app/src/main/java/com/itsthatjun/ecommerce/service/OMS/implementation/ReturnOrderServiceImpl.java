package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.itsthatjun.ecommerce.dto.ReturnParam;
import com.itsthatjun.ecommerce.exceptions.OMS.ReturnRequestException;
import com.itsthatjun.ecommerce.mbg.mapper.*;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.Messaging.OrderMessageService;
import com.itsthatjun.ecommerce.service.Messaging.ReturnMessageService;
import com.itsthatjun.ecommerce.service.OMS.ReturnOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ReturnOrderServiceImpl implements ReturnOrderService {

    private static final Logger LOG = LoggerFactory.getLogger(ReturnOrderServiceImpl.class);

    private final ReturnRequestMapper returnRequestMapper;

    private final ReturnReasonPicturesMapper picturesMapper;

    private final ReturnItemMapper returnItemMapper;

    private final OrderItemMapper orderItemMapper;

    private final ReturnMessageService messageService;

    private final OrdersMapper ordersMapper;

    private final CompanyAddressMapper companyAddressMapper;

    private final ReturnLogMapper logMapper;

    @Autowired
    public ReturnOrderServiceImpl(ReturnRequestMapper returnRequestMapper, ReturnReasonPicturesMapper picturesMapper,
                                  ReturnItemMapper returnItemMapper, ReturnMessageService messageService, OrderItemMapper orderItemMapper, OrdersMapper ordersMapper,
                                  CompanyAddressMapper companyAddressMapper, ReturnLogMapper logMapper) {
        this.returnRequestMapper = returnRequestMapper;
        this.picturesMapper = picturesMapper;
        this.returnItemMapper = returnItemMapper;
        this.orderItemMapper = orderItemMapper;
        this.messageService = messageService;
        this.ordersMapper = ordersMapper;
        this.companyAddressMapper = companyAddressMapper;
        this.logMapper = logMapper;
    }

    @Override
    public ReturnRequest getStatus(String orderSn, int userId) {
        ReturnRequest returnRquest = getUserReturnRequest(orderSn, userId);
        return returnRquest;
    }

    private ReturnRequest getUserReturnRequest(String orderSn, int userId) {
        ReturnRequestExample orderReturnRequestExample = new ReturnRequestExample();
        orderReturnRequestExample.createCriteria().andOrderSnEqualTo(orderSn).andMemberIdEqualTo(userId);
        List<ReturnRequest> orderReturnRequestList = returnRequestMapper.selectByExample(orderReturnRequestExample);

        if (orderReturnRequestList.isEmpty()) {
            throw new ReturnRequestException("Can't find return Request with order serial number: " + orderSn);
        } else {
            return orderReturnRequestList.get(0);
        }
    }

    @Override
    public ReturnRequest applyForReturn(ReturnRequest returnRequest, List<ReturnReasonPictures> picturesList, Map<String, Integer> skuQuantity,
                                              int userId) {
        String orderSn = returnRequest.getOrderSn();
        returnRequest.setOrderSn(orderSn);
        returnRequest.setCreatedAt(new Date());
        returnRequest.setMemberId(userId);
        returnRequest.setStatus(0);

        returnRequestMapper.insert(returnRequest);

        int returnRequestId = returnRequest.getId();

        double returnAmount = 0;

        // check for item validation from order and price
        for (String sku: skuQuantity.keySet()) {
            OrderItemExample orderItemExample = new OrderItemExample();
            orderItemExample.createCriteria().andOrderSnEqualTo(orderSn).andProductSkuCodeEqualTo(sku);
            List<OrderItem> orderItem = orderItemMapper.selectByExample(orderItemExample);

            if (orderItem.isEmpty()) throw new ReturnRequestException("Can not find order item with SKU code: " + sku);

            OrderItem item  = orderItem.get(0);
            int quantityToReturn = skuQuantity.get(sku);
            double purchasePrice = item.getRealAmount().doubleValue();

            ReturnItem returnItem = new ReturnItem();
            returnItem.setReturnRequestId(returnRequestId);
            returnItem.setOrderSn(orderSn);
            returnItem.setPurchasedPrice(BigDecimal.valueOf(purchasePrice));
            returnItem.setQuantity(quantityToReturn);
            returnItemMapper.insert(returnItem);

            returnAmount += purchasePrice * quantityToReturn;
        }

        returnRequest.setAskingAmount(BigDecimal.valueOf(returnAmount));

        // attach picture to request if any
        for (ReturnReasonPictures picture: picturesList) {
            picture.setCreatedAt(new Date());
            picture.setReturnRequestId(returnRequestId);
            picturesMapper.insert(picture);
        }

        // send out automatically reply, currently setup to be rejection after 3 days.
        ReturnParam returnParam = new ReturnParam();
        returnParam.setReturnRequest(returnRequest);
        messageService.sendDelayedReturnRequestReject(returnParam, userId);

        return returnRequest;
    }

    @Override
    public ReturnRequest updateReturnInfo(ReturnRequest returnRequest, List<ReturnReasonPictures> picturesList, String orderSn, int userId) {
        ReturnRequest foundReturnRequest = getUserReturnRequest(orderSn, userId);

        foundReturnRequest.setUpdatedAt(new Date());

        // TODO: update the info

        return returnRequest;
    }

    @Override
    public ReturnRequest delayedRejectReturn(String orderSn, int userId) {
        ReturnRequest returnRequest = getUserReturnRequest(orderSn, userId);

        // return status,  waiting to process 0 , returning(sending) 1, complete 2, rejected(not matching reason) 3
        if (returnRequest.getStatus() != 0) return returnRequest;

        returnRequest.setStatus(3);
        returnRequest.setHandleNote("Automatically rejection, no admin");  // TODO: might need to change rejection reason
        returnRequest.setHandleOperator("Automatically");
        returnRequest.setUpdatedAt(new Date());
        returnRequestMapper.updateByPrimaryKeySelective(returnRequest);

        createUpdateLog(returnRequest.getId(), "Rejected return Request request", "Automatically rejection");

        return returnRequest;
    }

    @Override // return status,  waiting to process 0 , returning(sending) 1, complete 2, rejected(not matching reason) 3. 4 cancel
    public ReturnRequest cancelReturn(String orderSn, int userId) {
        ReturnRequest foundReturnRequest = getUserReturnRequest(orderSn, userId);
        foundReturnRequest.setStatus(4);
        foundReturnRequest.setUpdatedAt(new Date());
        returnRequestMapper.updateByPrimaryKey(foundReturnRequest);
        return foundReturnRequest;
    }

    private void createUpdateLog(int returnRequestId, String updateAction, String operator) {
        ReturnLog log = new ReturnLog();
        log.setReturnRequestId(returnRequestId);
        log.setUpdateAction(updateAction);
        log.setOperator(operator);
        log.setCreatedAt(new Date());
        logMapper.insert(log);
    }
}
