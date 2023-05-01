package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ReceiveAddress;
import com.itsthatjun.ecommerce.mbg.model.ReceiveAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiveAddressMapper {
    long countByExample(ReceiveAddressExample example);

    int deleteByExample(ReceiveAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReceiveAddress record);

    int insertSelective(ReceiveAddress record);

    List<ReceiveAddress> selectByExample(ReceiveAddressExample example);

    ReceiveAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReceiveAddress record, @Param("example") ReceiveAddressExample example);

    int updateByExample(@Param("record") ReceiveAddress record, @Param("example") ReceiveAddressExample example);

    int updateByPrimaryKeySelective(ReceiveAddress record);

    int updateByPrimaryKey(ReceiveAddress record);
}