package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ArticleChangeLog;
import com.itsthatjun.ecommerce.mbg.model.ArticleChangeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleChangeLogMapper {
    long countByExample(ArticleChangeLogExample example);

    int deleteByExample(ArticleChangeLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleChangeLog record);

    int insertSelective(ArticleChangeLog record);

    List<ArticleChangeLog> selectByExample(ArticleChangeLogExample example);

    ArticleChangeLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleChangeLog record, @Param("example") ArticleChangeLogExample example);

    int updateByExample(@Param("record") ArticleChangeLog record, @Param("example") ArticleChangeLogExample example);

    int updateByPrimaryKeySelective(ArticleChangeLog record);

    int updateByPrimaryKey(ArticleChangeLog record);
}