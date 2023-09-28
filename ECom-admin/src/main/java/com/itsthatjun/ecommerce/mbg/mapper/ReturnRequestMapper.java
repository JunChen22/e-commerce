package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ReturnRequest;
import com.itsthatjun.ecommerce.mbg.model.ReturnRequestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturnRequestMapper {
    long countByExample(ReturnRequestExample example);

    int deleteByExample(ReturnRequestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReturnRequest record);

    int insertSelective(ReturnRequest record);

    List<ReturnRequest> selectByExample(ReturnRequestExample example);

    ReturnRequest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReturnRequest record, @Param("example") ReturnRequestExample example);

    int updateByExample(@Param("record") ReturnRequest record, @Param("example") ReturnRequestExample example);

    int updateByPrimaryKeySelective(ReturnRequest record);

    int updateByPrimaryKey(ReturnRequest record);
}