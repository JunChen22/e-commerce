package com.itsthatjun.ecommerce.service.CMS.implementation;

import com.itsthatjun.ecommerce.dao.CMS.ArticleDao;
import com.itsthatjun.ecommerce.dto.CMS.Articles;
import com.itsthatjun.ecommerce.exceptions.CMS.ArticleException;
import com.itsthatjun.ecommerce.mbg.mapper.ArticleImageMapper;
import com.itsthatjun.ecommerce.mbg.mapper.ArticleMapper;
import com.itsthatjun.ecommerce.mbg.mapper.ArticleQaMapper;
import com.itsthatjun.ecommerce.mbg.mapper.ArticleVideoMapper;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.CMS.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public List<Articles> getAllArticles() {
        //  TODO: it works but too much query to database
        return articleDao.getAllArticles();
    }

    @Override
    public Articles getArticle(int articleId) {
        return articleDao.getArticle(articleId);
    }
}
