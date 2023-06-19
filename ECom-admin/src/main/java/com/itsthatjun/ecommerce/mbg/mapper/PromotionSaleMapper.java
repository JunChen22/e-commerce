package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.PromotionSale;
import com.itsthatjun.ecommerce.mbg.model.PromotionSaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionSaleMapper {
    long countByExample(PromotionSaleExample example);

    int deleteByExample(PromotionSaleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PromotionSale record);

    int insertSelective(PromotionSale record);

    List<PromotionSale> selectByExample(PromotionSaleExample example);

    PromotionSale selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PromotionSale record, @Param("example") PromotionSaleExample example);

    int updateByExample(@Param("record") PromotionSale record, @Param("example") PromotionSaleExample example);

    int updateByPrimaryKeySelective(PromotionSale record);

    int updateByPrimaryKey(PromotionSale record);
}