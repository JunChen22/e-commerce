package com.example.spring.ecommerce.demo.springecommerce.dao;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminPermissionDao {

    List<Permission> getPermissionList(@Param("id") int id);
}
