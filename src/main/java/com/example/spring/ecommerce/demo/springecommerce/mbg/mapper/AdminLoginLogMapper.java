package com.example.spring.ecommerce.demo.springecommerce.mbg.mapper;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.AdminLoginLog;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.AdminLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminLoginLogMapper {
    long countByExample(AdminLoginLogExample example);

    int deleteByExample(AdminLoginLogExample example);

    int insert(AdminLoginLog record);

    int insertSelective(AdminLoginLog record);

    List<AdminLoginLog> selectByExample(AdminLoginLogExample example);

    int updateByExampleSelective(@Param("record") AdminLoginLog record, @Param("example") AdminLoginLogExample example);

    int updateByExample(@Param("record") AdminLoginLog record, @Param("example") AdminLoginLogExample example);
}