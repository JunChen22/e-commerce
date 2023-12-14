package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ArticleVideo;
import com.itsthatjun.ecommerce.mbg.model.ArticleVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleVideoMapper {
    long countByExample(ArticleVideoExample example);

    int deleteByExample(ArticleVideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleVideo record);

    int insertSelective(ArticleVideo record);

    List<ArticleVideo> selectByExample(ArticleVideoExample example);

    ArticleVideo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleVideo record, @Param("example") ArticleVideoExample example);

    int updateByExample(@Param("record") ArticleVideo record, @Param("example") ArticleVideoExample example);

    int updateByPrimaryKeySelective(ArticleVideo record);

    int updateByPrimaryKey(ArticleVideo record);
}