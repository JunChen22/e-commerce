package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ProductPictures;
import com.itsthatjun.ecommerce.mbg.model.ProductPicturesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductPicturesMapper {
    long countByExample(ProductPicturesExample example);

    int deleteByExample(ProductPicturesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductPictures record);

    int insertSelective(ProductPictures record);

    List<ProductPictures> selectByExample(ProductPicturesExample example);

    ProductPictures selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductPictures record, @Param("example") ProductPicturesExample example);

    int updateByExample(@Param("record") ProductPictures record, @Param("example") ProductPicturesExample example);

    int updateByPrimaryKeySelective(ProductPictures record);

    int updateByPrimaryKey(ProductPictures record);
}