package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ReturnItem;
import com.itsthatjun.ecommerce.mbg.model.ReturnItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturnItemMapper {
    long countByExample(ReturnItemExample example);

    int deleteByExample(ReturnItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReturnItem record);

    int insertSelective(ReturnItem record);

    List<ReturnItem> selectByExample(ReturnItemExample example);

    ReturnItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReturnItem record, @Param("example") ReturnItemExample example);

    int updateByExample(@Param("record") ReturnItem record, @Param("example") ReturnItemExample example);

    int updateByPrimaryKeySelective(ReturnItem record);

    int updateByPrimaryKey(ReturnItem record);
}