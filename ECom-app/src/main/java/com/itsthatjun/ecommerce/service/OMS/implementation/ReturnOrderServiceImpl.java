package com.itsthatjun.ecommerce.service.OMS.implementation;

import com.itsthatjun.ecommerce.exceptions.OMS.ReturnRequestException;
import com.itsthatjun.ecommerce.mbg.mapper.*;
import com.itsthatjun.ecommerce.mbg.model.*;
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

    private final OrdersMapper ordersMapper;

    private final CompanyAddressMapper companyAddressMapper;

    private final ReturnLogMapper logMapper;

    @Autowired
    public ReturnOrderServiceImpl(ReturnRequestMapper returnRequestMapper, ReturnReasonPicturesMapper picturesMapper, ReturnItemMapper returnItemMapper,
                                  OrderItemMapper orderItemMapper, OrdersMapper ordersMapper, CompanyAddressMapper companyAddressMapper, ReturnLogMapper logMapper) {
        this.returnRequestMapper = returnRequestMapper;
        this.picturesMapper = picturesMapper;
        this.returnItemMapper = returnItemMapper;
        this.orderItemMapper = orderItemMapper;
        this.ordersMapper = ordersMapper;
        this.companyAddressMapper = companyAddressMapper;
        this.logMapper = logMapper;
    }

    @Override
    public ReturnRequest getStatus(String orderSn, int userId) {

        ReturnRequestExample returnRequestExample = new ReturnRequestExample();
        returnRequestExample.createCriteria().andOrderSnEqualTo(orderSn).andMemberIdEqualTo(userId);
        List<ReturnRequest> returnRequest = returnRequestMapper.selectByExample(returnRequestExample);
        return returnRequest.get(0);
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

        double returnAmount = 0;

        for (String sku: skuQuantity.keySet()) {
            OrderItemExample orderItemExample = new OrderItemExample();
            orderItemExample.createCriteria().andOrderSnEqualTo(orderSn).andProductSkuCodeEqualTo(sku);
            List<OrderItem> orderItem = orderItemMapper.selectByExample(orderItemExample);

            if (orderItem.isEmpty()) {
                throw new RuntimeException("Can not find order item with SKU code: " + sku);
            }
            OrderItem item  = orderItem.get(0);
            int quantityToReturn = skuQuantity.get(sku);
            returnAmount += item.getRealAmount().doubleValue() * quantityToReturn;
        }

        returnRequest.setAskingAmount(BigDecimal.valueOf(returnAmount));

        int returnRequestId = returnRequest.getId();

        for (ReturnReasonPictures picture: picturesList) {
            picture.setCreatedAt(new Date());
            picture.setReturnRequestId(returnRequestId);
            picturesMapper.insert(picture);
        }

        return returnRequest;
    }

    @Override
    public ReturnRequest updateReturnInfo(ReturnRequest returnRequest, List<ReturnReasonPictures> picturesList, String orderSn, int userId) {
        ReturnRequestExample orderReturnRequestExample = new ReturnRequestExample();
        orderReturnRequestExample.createCriteria().andOrderSnEqualTo(orderSn).andMemberIdEqualTo(userId);
        List<ReturnRequest> orderReturnRequestList = returnRequestMapper.selectByExample(orderReturnRequestExample);

        if (orderReturnRequestList.isEmpty()) {
            throw new ReturnRequestException("Can't find return Request with order serial number: " + orderSn);
        }

        ReturnRequest foundReturnRequest = orderReturnRequestList.get(0);

        foundReturnRequest.setUpdatedAt(new Date());

        return returnRequest;
    }

    @Override
    public ReturnRequest cancelReturn(String orderSn, int userId) {

        ReturnRequestExample orderReturnRequestExample = new ReturnRequestExample();
        orderReturnRequestExample.createCriteria().andOrderSnEqualTo(orderSn).andMemberIdEqualTo(userId);
        List<ReturnRequest> orderReturnRequestList = returnRequestMapper.selectByExample(orderReturnRequestExample);

        if (orderReturnRequestList.isEmpty()) {
            throw new ReturnRequestException("Can't find return Request with order serial number: " + orderSn);
        }

        ReturnRequest foundReturnRequest = orderReturnRequestList.get(0);

        foundReturnRequest.setStatus(4);               // return status,  waiting to process 0 , returning(sending) 1, complete 2, rejected(not matching reason) 3. 4 cancel
        foundReturnRequest.setUpdatedAt(new Date());

        returnRequestMapper.updateByPrimaryKey(foundReturnRequest);

        return foundReturnRequest;
    }
}
