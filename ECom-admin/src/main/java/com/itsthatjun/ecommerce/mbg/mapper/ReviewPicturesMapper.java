package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ReviewPictures;
import com.itsthatjun.ecommerce.mbg.model.ReviewPicturesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReviewPicturesMapper {
    long countByExample(ReviewPicturesExample example);

    int deleteByExample(ReviewPicturesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReviewPictures record);

    int insertSelective(ReviewPictures record);

    List<ReviewPictures> selectByExample(ReviewPicturesExample example);

    ReviewPictures selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReviewPictures record, @Param("example") ReviewPicturesExample example);

    int updateByExample(@Param("record") ReviewPictures record, @Param("example") ReviewPicturesExample example);

    int updateByPrimaryKeySelective(ReviewPictures record);

    int updateByPrimaryKey(ReviewPictures record);
}