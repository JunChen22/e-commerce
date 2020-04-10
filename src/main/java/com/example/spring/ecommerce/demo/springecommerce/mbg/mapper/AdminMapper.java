package com.example.spring.ecommerce.demo.springecommerce.mbg.mapper;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Admin;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);
}