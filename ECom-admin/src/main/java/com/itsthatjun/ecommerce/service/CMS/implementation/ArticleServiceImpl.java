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

    private final ArticleMapper articleMapper;

    private final ArticleDao articleDao;

    private final ArticleVideoMapper videoMapper;

    private final ArticleQaMapper qaMapper;

    private final ArticleImageMapper imageMapper;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper, ArticleDao articleDao, ArticleVideoMapper videoMapper, ArticleQaMapper qaMapper, ArticleImageMapper imageMapper) {
        this.articleMapper = articleMapper;
        this.articleDao = articleDao;
        this.videoMapper = videoMapper;
        this.qaMapper = qaMapper;
        this.imageMapper = imageMapper;
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

    @Override
    public Articles createArticle(Articles article) {
        //TODO: optimize this
        Article exist = articleMapper.selectByPrimaryKey(article.getArticle().getId());
        if(exist != null) {
            System.out.println("existing id");
            // TODO: return exception tobe added in ECom-common
            return null;
        }

        Date currentDate = new Date();
        article.getArticle().setCreatedAt(currentDate);
        articleMapper.insert(article.getArticle());
        int articleID = article.getArticle().getId();
        if(!article.getQA().isEmpty()){
            for(ArticleQa qa: article.getQA()) {
                qa.setArticleId(articleID);
                qa.setCreatedAt(currentDate);
                qaMapper.insert(qa);
            }
        }

        if(!article.getImages().isEmpty()){
            for(ArticleImage image: article.getImages()) {
                image.setArticleId(articleID);
                image.setCreatedAt(currentDate);
                imageMapper.insert(image);
            }
        }

        if(!article.getVideos().isEmpty()){
            for(ArticleVideo video: article.getVideos()) {
                video.setArticleId(articleID);
                video.setCreatedAt(currentDate);
                videoMapper.insert(video);
            }
        }
        return article;
    }

    @Override
    // TODO: update when deleting one of the element
    public Articles updateArticle(Articles article) {
        int articleId = article.getArticle().getId();
        ArticleExample example = new ArticleExample();
        example.createCriteria().andIdEqualTo(articleId);

        List<Article> existingArticles = articleMapper.selectByExample(example);
        if (existingArticles.isEmpty()) {
            System.out.println(article.getArticle().getId() + " does not exist");
            return null;
        }

        Date currentDate = new Date();
        Article exitingArticle = existingArticles.get(0);
        exitingArticle.setUpdatedAt(currentDate);

        articleMapper.updateByPrimaryKey(article.getArticle());
        updateQA(articleId, article.getQA());
        updateImage(articleId, article.getImages());
        updateVideo(articleId, article.getVideos());

        int rowAffected = articleMapper.updateByExample(exitingArticle, example);
        if (rowAffected > 0) {
            article.setArticle(exitingArticle);
            return article;
        } else {
            System.out.println("Failed to update Article with ID " + articleId);
            return null;
        }
    }

    // TODO: newly created won't have primary key
    private int updateQA(int articleId, List<ArticleQa> qaList) {
        for (ArticleQa qa: qaList) {
            LocalDate localDate = LocalDate.now();
            java.sql.Date date = java.sql.Date.valueOf(localDate);
            qa.setUpdatedAt(date);
            qa.setArticleId(articleId);
            qaMapper.updateByPrimaryKey(qa);
        }
        return qaList.size();
    }

    private int updateImage(int articleId, List<ArticleImage> imageList){
        for (ArticleImage image: imageList) {
            LocalDate localDate = LocalDate.now();
            java.sql.Date date = java.sql.Date.valueOf(localDate);
            image.setUpdatedAt(date);
            image.setArticleId(articleId);
            imageMapper.updateByPrimaryKey(image);
        }
        return imageList.size();
    }

    private int updateVideo(int articleId, List<ArticleVideo> videoList) {
        for (ArticleVideo video: videoList) {
            LocalDate localDate = LocalDate.now();
            java.sql.Date date = java.sql.Date.valueOf(localDate);
            video.setUpdatedAt(date);
            video.setArticleId(articleId);
            videoMapper.updateByPrimaryKey(video);
        }
        return videoList.size();
    }

    @Override
    public void deleteArticle(int articleId) {

        if (articleMapper.selectByPrimaryKey(articleId) == null) {
            throw new ArticleException("Article not found with ID: " + articleId);
        }

        Articles article = getArticle(articleId);

        articleMapper.deleteByPrimaryKey(articleId);

        for (ArticleQa qa: article.getQA()) {
            qaMapper.deleteByPrimaryKey(qa.getId());
        }

        for (ArticleVideo video: article.getVideos()) {
            videoMapper.deleteByPrimaryKey(video.getId());
        }

        for (ArticleImage image: article.getImages()) {
            imageMapper.deleteByPrimaryKey(image.getId());
        }
    }
}
