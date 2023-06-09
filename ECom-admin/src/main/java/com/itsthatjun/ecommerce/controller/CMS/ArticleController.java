package com.itsthatjun.ecommerce.controller.CMS;

import com.itsthatjun.ecommerce.dto.CMS.Articles;
import com.itsthatjun.ecommerce.service.CMS.implementation.ArticleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@Api(tags = "content related", description = "CRUD articles like buyer's guide, product comparison, and MISC articles")
public class ArticleController {

    private final ArticleServiceImpl articleService;

    @Autowired
    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "")
    public List<Articles> getAllArticle() {
        return articleService.getAllArticles();
    }

    @PostMapping("/create")
    @ApiOperation(value = "create an article(buyer's guide, comparison, and etc)")
    public Articles createArticle(@RequestBody Articles articles) {
        return articleService.createArticle(articles);
    }

    @PostMapping("/update")
    @ApiOperation(value = "update an article and it's content")
    public Articles updateArticle(@RequestBody Articles articles) {
        articleService.updateArticle(articles);
        return articles;
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "delete article and it's related content(QA, videos, and images)")
    public Articles deleteArticle(Articles article) {
        articleService.deleteArticle(article);
        return article;
    }
}
