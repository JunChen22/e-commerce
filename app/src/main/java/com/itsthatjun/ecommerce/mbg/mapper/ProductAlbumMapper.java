package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ProductAlbum;
import com.itsthatjun.ecommerce.mbg.model.ProductAlbumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductAlbumMapper {
    long countByExample(ProductAlbumExample example);

    int deleteByExample(ProductAlbumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductAlbum record);

    int insertSelective(ProductAlbum record);

    List<ProductAlbum> selectByExample(ProductAlbumExample example);

    ProductAlbum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductAlbum record, @Param("example") ProductAlbumExample example);

    int updateByExample(@Param("record") ProductAlbum record, @Param("example") ProductAlbumExample example);

    int updateByPrimaryKeySelective(ProductAlbum record);

    int updateByPrimaryKey(ProductAlbum record);
}