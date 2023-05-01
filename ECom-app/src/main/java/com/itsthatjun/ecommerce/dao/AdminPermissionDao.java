package com.itsthatjun.ecommerce.dao;

import com.itsthatjun.ecommerce.mbg.model.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminPermissionDao {

    List<Permission> getPermissionList(@Param("id") int id);
}
