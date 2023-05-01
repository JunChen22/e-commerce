package com.itsthatjun.ecommerce.dao;

import com.itsthatjun.ecommerce.domainmodel.OrderDetail;
import com.itsthatjun.ecommerce.mbg.model.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

    OrderDetail getDetail(@Param("orderId") Long Id);

    int updateSkuStock(@Param("itemList") List<OrderItem> orderItemList);

    int updateOrderStatus(@Param("ids") List<Long> ids, @Param("status") Integer status);

    int releaseSkuStockLock(@Param("itemList") List<OrderItem> orderItemList);

}
