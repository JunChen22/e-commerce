package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.MemberChangeLog;
import com.itsthatjun.ecommerce.mbg.model.MemberChangeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberChangeLogMapper {
    long countByExample(MemberChangeLogExample example);

    int deleteByExample(MemberChangeLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberChangeLog record);

    int insertSelective(MemberChangeLog record);

    List<MemberChangeLog> selectByExample(MemberChangeLogExample example);

    MemberChangeLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberChangeLog record, @Param("example") MemberChangeLogExample example);

    int updateByExample(@Param("record") MemberChangeLog record, @Param("example") MemberChangeLogExample example);

    int updateByPrimaryKeySelective(MemberChangeLog record);

    int updateByPrimaryKey(MemberChangeLog record);
}