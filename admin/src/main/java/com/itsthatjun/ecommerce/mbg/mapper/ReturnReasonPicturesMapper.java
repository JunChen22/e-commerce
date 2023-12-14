package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ReturnReasonPictures;
import com.itsthatjun.ecommerce.mbg.model.ReturnReasonPicturesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturnReasonPicturesMapper {
    long countByExample(ReturnReasonPicturesExample example);

    int deleteByExample(ReturnReasonPicturesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReturnReasonPictures record);

    int insertSelective(ReturnReasonPictures record);

    List<ReturnReasonPictures> selectByExample(ReturnReasonPicturesExample example);

    ReturnReasonPictures selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReturnReasonPictures record, @Param("example") ReturnReasonPicturesExample example);

    int updateByExample(@Param("record") ReturnReasonPictures record, @Param("example") ReturnReasonPicturesExample example);

    int updateByPrimaryKeySelective(ReturnReasonPictures record);

    int updateByPrimaryKey(ReturnReasonPictures record);
}