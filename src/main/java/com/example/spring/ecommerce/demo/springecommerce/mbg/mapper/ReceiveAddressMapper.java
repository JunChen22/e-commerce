package com.example.spring.ecommerce.demo.springecommerce.mbg.mapper;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.ReceiveAddress;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.ReceiveAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiveAddressMapper {
    long countByExample(ReceiveAddressExample example);

    int deleteByExample(ReceiveAddressExample example);

    int insert(ReceiveAddress record);

    int insertSelective(ReceiveAddress record);

    List<ReceiveAddress> selectByExample(ReceiveAddressExample example);

    int updateByExampleSelective(@Param("record") ReceiveAddress record, @Param("example") ReceiveAddressExample example);

    int updateByExample(@Param("record") ReceiveAddress record, @Param("example") ReceiveAddressExample example);
}