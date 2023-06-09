package com.itsthatjun.ecommerce.service.CMS;

import com.itsthatjun.ecommerce.dto.CMS.Articles;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public interface ArticleService {

    @ApiModelProperty(value = "")
    List<Articles> getAllArticles();

    @ApiModelProperty(value = "")
    Articles createArticle(Articles article);

    @ApiModelProperty(value = "")
    Articles updateArticle(Articles article);

    @ApiModelProperty(value = "")
    void deleteArticle(Articles article);
}
