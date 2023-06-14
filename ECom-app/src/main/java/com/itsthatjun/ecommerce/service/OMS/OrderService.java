package com.itsthatjun.ecommerce.service.OMS;

import com.itsthatjun.ecommerce.dto.OrderParam;
import com.itsthatjun.ecommerce.mbg.model.CartItem;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface OrderService {

    @ApiModelProperty("")
    List<CartItem> generateCartItem();

    @Transactional
    @ApiModelProperty("")
    Map<String, Object> generateOrder(OrderParam orderParam);

    @Transactional
    @ApiModelProperty("")
    Integer paySuccess(Long OrderId, Integer payType);

    @Transactional
    @ApiModelProperty("")
    String cancelOrder(Long orderId);

    @ApiModelProperty("list all user orders")
    List<Orders> list(int status, int pageNum, int pageSize);
}
