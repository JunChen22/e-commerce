package com.itsthatjun.ecommerce.dao.OMS;

import com.itsthatjun.ecommerce.dto.OMS.OrderDetail;
import com.itsthatjun.ecommerce.mbg.model.OrderItem;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

    @ApiModelProperty(value = "Get the order detail by order ID", example = "12345")
    OrderDetail getDetail(@Param("orderId") Long Id);

    @ApiModelProperty(value = "Update the stock of SKUs in the given list of order items")
    int updateSkuStock(@Param("itemList") List<OrderItem> orderItemList);

    @ApiModelProperty(value = "Update the status of the orders with the given IDs", example = "[1, 2, 3]")
    int updateOrderStatus(@Param("ids") List<Long> ids, @Param("status") Integer status);

    @ApiModelProperty(value = "Release the stock locks of SKUs in the given list of order items")
    int releaseSkuStockLock(@Param("itemList") List<OrderItem> orderItemList);
}