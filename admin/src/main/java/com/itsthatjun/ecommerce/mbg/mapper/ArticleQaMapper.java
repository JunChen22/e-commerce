package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ArticleQa;
import com.itsthatjun.ecommerce.mbg.model.ArticleQaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleQaMapper {
    long countByExample(ArticleQaExample example);

    int deleteByExample(ArticleQaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleQa record);

    int insertSelective(ArticleQa record);

    List<ArticleQa> selectByExample(ArticleQaExample example);

    ArticleQa selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleQa record, @Param("example") ArticleQaExample example);

    int updateByExample(@Param("record") ArticleQa record, @Param("example") ArticleQaExample example);

    int updateByPrimaryKeySelective(ArticleQa record);

    int updateByPrimaryKey(ArticleQa record);
}