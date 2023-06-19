package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.OrderReturnReasonPictures;
import com.itsthatjun.ecommerce.mbg.model.OrderReturnReasonPicturesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderReturnReasonPicturesMapper {
    long countByExample(OrderReturnReasonPicturesExample example);

    int deleteByExample(OrderReturnReasonPicturesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderReturnReasonPictures record);

    int insertSelective(OrderReturnReasonPictures record);

    List<OrderReturnReasonPictures> selectByExample(OrderReturnReasonPicturesExample example);

    OrderReturnReasonPictures selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderReturnReasonPictures record, @Param("example") OrderReturnReasonPicturesExample example);

    int updateByExample(@Param("record") OrderReturnReasonPictures record, @Param("example") OrderReturnReasonPicturesExample example);

    int updateByPrimaryKeySelective(OrderReturnReasonPictures record);

    int updateByPrimaryKey(OrderReturnReasonPictures record);
}