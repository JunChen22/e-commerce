package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.CartItem;
import com.itsthatjun.ecommerce.mbg.model.CartItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartItemMapper {
    long countByExample(CartItemExample example);

    int deleteByExample(CartItemExample example);

    int insert(CartItem record);

    int insertSelective(CartItem record);

    List<CartItem> selectByExample(CartItemExample example);

    int updateByExampleSelective(@Param("record") CartItem record, @Param("example") CartItemExample example);

    int updateByExample(@Param("record") CartItem record, @Param("example") CartItemExample example);
}