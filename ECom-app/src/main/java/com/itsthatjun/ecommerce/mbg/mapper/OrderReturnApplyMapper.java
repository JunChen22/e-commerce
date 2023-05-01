package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.OrderReturnApply;
import com.itsthatjun.ecommerce.mbg.model.OrderReturnApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderReturnApplyMapper {
    long countByExample(OrderReturnApplyExample example);

    int deleteByExample(OrderReturnApplyExample example);

    int insert(OrderReturnApply record);

    int insertSelective(OrderReturnApply record);

    List<OrderReturnApply> selectByExample(OrderReturnApplyExample example);

    int updateByExampleSelective(@Param("record") OrderReturnApply record, @Param("example") OrderReturnApplyExample example);

    int updateByExample(@Param("record") OrderReturnApply record, @Param("example") OrderReturnApplyExample example);
}