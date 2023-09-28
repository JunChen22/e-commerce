package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.MemberIcon;
import com.itsthatjun.ecommerce.mbg.model.MemberIconExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberIconMapper {
    long countByExample(MemberIconExample example);

    int deleteByExample(MemberIconExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberIcon record);

    int insertSelective(MemberIcon record);

    List<MemberIcon> selectByExample(MemberIconExample example);

    MemberIcon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberIcon record, @Param("example") MemberIconExample example);

    int updateByExample(@Param("record") MemberIcon record, @Param("example") MemberIconExample example);

    int updateByPrimaryKeySelective(MemberIcon record);

    int updateByPrimaryKey(MemberIcon record);
}