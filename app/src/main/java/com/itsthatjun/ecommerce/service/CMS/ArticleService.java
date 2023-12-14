package com.itsthatjun.ecommerce.service.CMS;

import com.itsthatjun.ecommerce.dto.CMS.Articles;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public interface ArticleService {

    @ApiModelProperty(value = "get all articles")
    List<Articles> getAllArticles();

    @ApiModelProperty(value = "get article based on id")
    Articles getArticle(int articleId);
}
