package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.CompanyAddress;
import com.itsthatjun.ecommerce.mbg.model.CompanyAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyAddressMapper {
    long countByExample(CompanyAddressExample example);

    int deleteByExample(CompanyAddressExample example);

    int insert(CompanyAddress record);

    int insertSelective(CompanyAddress record);

    List<CompanyAddress> selectByExample(CompanyAddressExample example);

    int updateByExampleSelective(@Param("record") CompanyAddress record, @Param("example") CompanyAddressExample example);

    int updateByExample(@Param("record") CompanyAddress record, @Param("example") CompanyAddressExample example);
}