package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.OrderChangeHistory;
import com.itsthatjun.ecommerce.mbg.model.OrderChangeHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderChangeHistoryMapper {
    long countByExample(OrderChangeHistoryExample example);

    int deleteByExample(OrderChangeHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderChangeHistory record);

    int insertSelective(OrderChangeHistory record);

    List<OrderChangeHistory> selectByExample(OrderChangeHistoryExample example);

    OrderChangeHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderChangeHistory record, @Param("example") OrderChangeHistoryExample example);

    int updateByExample(@Param("record") OrderChangeHistory record, @Param("example") OrderChangeHistoryExample example);

    int updateByPrimaryKeySelective(OrderChangeHistory record);

    int updateByPrimaryKey(OrderChangeHistory record);
}