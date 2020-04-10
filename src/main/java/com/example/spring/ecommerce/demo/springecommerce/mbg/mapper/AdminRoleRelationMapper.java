package com.example.spring.ecommerce.demo.springecommerce.mbg.mapper;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.AdminRoleRelation;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.AdminRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminRoleRelationMapper {
    long countByExample(AdminRoleRelationExample example);

    int deleteByExample(AdminRoleRelationExample example);

    int insert(AdminRoleRelation record);

    int insertSelective(AdminRoleRelation record);

    List<AdminRoleRelation> selectByExample(AdminRoleRelationExample example);

    int updateByExampleSelective(@Param("record") AdminRoleRelation record, @Param("example") AdminRoleRelationExample example);

    int updateByExample(@Param("record") AdminRoleRelation record, @Param("example") AdminRoleRelationExample example);
}