package com.itsthatjun.ecommerce.service.CMS;

import com.itsthatjun.ecommerce.dto.CMS.Articles;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public interface ArticleService {

    @ApiModelProperty(value = "get all articles")
    List<Articles> getAllArticles();

    @ApiModelProperty(value = "get article based on id")
    Articles getArticle(int articleId);
    @ApiModelProperty(value = "create article")
    Articles createArticle(Articles article);

    @ApiModelProperty(value = "update/add article and its media content")
    Articles updateArticle(Articles article);

    @ApiModelProperty(value = "delete article and all of its media content")
    void deleteArticle(int articleId);
}
