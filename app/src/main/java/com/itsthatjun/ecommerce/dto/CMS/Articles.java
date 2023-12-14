package com.itsthatjun.ecommerce.dto.CMS;


import com.itsthatjun.ecommerce.mbg.model.Article;
import com.itsthatjun.ecommerce.mbg.model.ArticleImage;
import com.itsthatjun.ecommerce.mbg.model.ArticleQa;
import com.itsthatjun.ecommerce.mbg.model.ArticleVideo;
import lombok.Data;

import java.util.List;

@Data
public class Articles {
    private Article article;
    private List<ArticleQa> QA;
    private List<ArticleImage> images;
    private List<ArticleVideo> videos;
}
