package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.OrderReturnReasonFiles;
import com.itsthatjun.ecommerce.mbg.model.OrderReturnReasonFilesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderReturnReasonFilesMapper {
    long countByExample(OrderReturnReasonFilesExample example);

    int deleteByExample(OrderReturnReasonFilesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderReturnReasonFiles record);

    int insertSelective(OrderReturnReasonFiles record);

    List<OrderReturnReasonFiles> selectByExample(OrderReturnReasonFilesExample example);

    OrderReturnReasonFiles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderReturnReasonFiles record, @Param("example") OrderReturnReasonFilesExample example);

    int updateByExample(@Param("record") OrderReturnReasonFiles record, @Param("example") OrderReturnReasonFilesExample example);

    int updateByPrimaryKeySelective(OrderReturnReasonFiles record);

    int updateByPrimaryKey(OrderReturnReasonFiles record);
}