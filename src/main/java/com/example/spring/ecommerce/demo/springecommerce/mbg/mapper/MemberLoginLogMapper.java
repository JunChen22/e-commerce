package com.example.spring.ecommerce.demo.springecommerce.mbg.mapper;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.MemberLoginLog;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.MemberLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberLoginLogMapper {
    long countByExample(MemberLoginLogExample example);

    int deleteByExample(MemberLoginLogExample example);

    int insert(MemberLoginLog record);

    int insertSelective(MemberLoginLog record);

    List<MemberLoginLog> selectByExample(MemberLoginLogExample example);

    int updateByExampleSelective(@Param("record") MemberLoginLog record, @Param("example") MemberLoginLogExample example);

    int updateByExample(@Param("record") MemberLoginLog record, @Param("example") MemberLoginLogExample example);
}