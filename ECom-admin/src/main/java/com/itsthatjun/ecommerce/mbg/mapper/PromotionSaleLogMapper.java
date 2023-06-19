package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.PromotionSaleLog;
import com.itsthatjun.ecommerce.mbg.model.PromotionSaleLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionSaleLogMapper {
    long countByExample(PromotionSaleLogExample example);

    int deleteByExample(PromotionSaleLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PromotionSaleLog record);

    int insertSelective(PromotionSaleLog record);

    List<PromotionSaleLog> selectByExample(PromotionSaleLogExample example);

    PromotionSaleLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PromotionSaleLog record, @Param("example") PromotionSaleLogExample example);

    int updateByExample(@Param("record") PromotionSaleLog record, @Param("example") PromotionSaleLogExample example);

    int updateByPrimaryKeySelective(PromotionSaleLog record);

    int updateByPrimaryKey(PromotionSaleLog record);
}