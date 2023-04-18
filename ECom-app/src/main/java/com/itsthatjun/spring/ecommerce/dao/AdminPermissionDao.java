package com.itsthatjun.spring.ecommerce.dao;

import com.itsthatjun.spring.ecommerce.mbg.model.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminPermissionDao {

    List<Permission> getPermissionList(@Param("id") int id);
}
