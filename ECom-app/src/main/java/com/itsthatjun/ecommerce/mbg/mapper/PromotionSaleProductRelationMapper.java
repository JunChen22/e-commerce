package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.PromotionSaleProductRelation;
import com.itsthatjun.ecommerce.mbg.model.PromotionSaleProductRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionSaleProductRelationMapper {
    long countByExample(PromotionSaleProductRelationExample example);

    int deleteByExample(PromotionSaleProductRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PromotionSaleProductRelation record);

    int insertSelective(PromotionSaleProductRelation record);

    List<PromotionSaleProductRelation> selectByExample(PromotionSaleProductRelationExample example);

    PromotionSaleProductRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PromotionSaleProductRelation record, @Param("example") PromotionSaleProductRelationExample example);

    int updateByExample(@Param("record") PromotionSaleProductRelation record, @Param("example") PromotionSaleProductRelationExample example);

    int updateByPrimaryKeySelective(PromotionSaleProductRelation record);

    int updateByPrimaryKey(PromotionSaleProductRelation record);
}