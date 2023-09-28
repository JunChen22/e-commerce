package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.PromotionSaleProduct;
import com.itsthatjun.ecommerce.mbg.model.PromotionSaleProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionSaleProductMapper {
    long countByExample(PromotionSaleProductExample example);

    int deleteByExample(PromotionSaleProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PromotionSaleProduct record);

    int insertSelective(PromotionSaleProduct record);

    List<PromotionSaleProduct> selectByExample(PromotionSaleProductExample example);

    PromotionSaleProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PromotionSaleProduct record, @Param("example") PromotionSaleProductExample example);

    int updateByExample(@Param("record") PromotionSaleProduct record, @Param("example") PromotionSaleProductExample example);

    int updateByPrimaryKeySelective(PromotionSaleProduct record);

    int updateByPrimaryKey(PromotionSaleProduct record);
}