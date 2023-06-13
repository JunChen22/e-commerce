package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.dto.OrderParam;
import com.itsthatjun.ecommerce.mbg.model.CartItem;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<CartItem> generateCartItem();

    @Transactional
    Map<String, Object> generateOrder(OrderParam orderParam);

    @Transactional
    Integer paySuccess(Long OrderId, Integer payType);

    @Transactional
    String cancelOrder(Long orderId);

    List<Orders> list(int status, int pageNum, int pageSize);
}
