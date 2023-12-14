package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ReviewAlbum;
import com.itsthatjun.ecommerce.mbg.model.ReviewAlbumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReviewAlbumMapper {
    long countByExample(ReviewAlbumExample example);

    int deleteByExample(ReviewAlbumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReviewAlbum record);

    int insertSelective(ReviewAlbum record);

    List<ReviewAlbum> selectByExample(ReviewAlbumExample example);

    ReviewAlbum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReviewAlbum record, @Param("example") ReviewAlbumExample example);

    int updateByExample(@Param("record") ReviewAlbum record, @Param("example") ReviewAlbumExample example);

    int updateByPrimaryKeySelective(ReviewAlbum record);

    int updateByPrimaryKey(ReviewAlbum record);
}