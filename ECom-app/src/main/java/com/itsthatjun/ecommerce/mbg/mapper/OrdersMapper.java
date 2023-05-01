package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.Orders;
import com.itsthatjun.ecommerce.mbg.model.OrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {
    long countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);
}