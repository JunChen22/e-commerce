package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ReviewUpdateLog;
import com.itsthatjun.ecommerce.mbg.model.ReviewUpdateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReviewUpdateLogMapper {
    long countByExample(ReviewUpdateLogExample example);

    int deleteByExample(ReviewUpdateLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReviewUpdateLog record);

    int insertSelective(ReviewUpdateLog record);

    List<ReviewUpdateLog> selectByExample(ReviewUpdateLogExample example);

    ReviewUpdateLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReviewUpdateLog record, @Param("example") ReviewUpdateLogExample example);

    int updateByExample(@Param("record") ReviewUpdateLog record, @Param("example") ReviewUpdateLogExample example);

    int updateByPrimaryKeySelective(ReviewUpdateLog record);

    int updateByPrimaryKey(ReviewUpdateLog record);
}