package com.itsthatjun.ecommerce.service.PMS.implementation;

import com.itsthatjun.ecommerce.dto.PMS.ProductReview;
import com.itsthatjun.ecommerce.mbg.mapper.*;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.PMS.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;

    private final ReviewAlbumMapper albumMapper;

    private final ReviewPicturesMapper picturesMapper;

    private final ReviewUpdateLogMapper updateLogMapper;

    @Autowired
    public ReviewServiceImpl(ReviewMapper reviewMapper, ReviewAlbumMapper albumMapper, ReviewPicturesMapper picturesMapper, ReviewUpdateLogMapper updateLogMapper) {
        this.reviewMapper = reviewMapper;
        this.albumMapper = albumMapper;
        this.picturesMapper = picturesMapper;
        this.updateLogMapper = updateLogMapper;
    }

    @Override
    public ProductReview getDetailReview(int reviewId) {

        Review review = reviewMapper.selectByPrimaryKey(reviewId);
        ProductReview productReview = new ProductReview();
        productReview.setReview(review);

        ReviewAlbumExample albumExample = new ReviewAlbumExample();
        albumExample.createCriteria().andReviewIdEqualTo(reviewId);
        ReviewAlbum foundAlbum = albumMapper.selectByExample(albumExample).get(0);

        int albumId = foundAlbum.getId();

        ReviewPicturesExample reviewPicturesExample = new ReviewPicturesExample();
        reviewPicturesExample.createCriteria().andReviewAlbumIdEqualTo(albumId);
        List<ReviewPictures> reviewPicturesList = picturesMapper.selectByExample(reviewPicturesExample);

        productReview.setPicturesList(reviewPicturesList);
        return productReview;
    }

    @Override
    public List<ProductReview> listProductAllReview(int productId) {
        ReviewExample reviewExample = new ReviewExample();
        reviewExample.createCriteria().andProductIdEqualTo(productId);
        List<Review> productReviews = reviewMapper.selectByExample(reviewExample);

        List<ProductReview> productReviewList = new ArrayList<>();

        if (productReviews.isEmpty()) return productReviewList;

        for (Review review: productReviews) {
            // copy over information
            ProductReview productReview = new ProductReview();
            productReview.setReview(review);

            int reviewId = review.getId();

            ReviewAlbumExample albumExample = new ReviewAlbumExample();
            albumExample.createCriteria().andReviewIdEqualTo(reviewId);
            ReviewAlbum foundAlbum = albumMapper.selectByExample(albumExample).get(0);

            int albumId = foundAlbum.getId();

            ReviewPicturesExample reviewPicturesExample = new ReviewPicturesExample();
            reviewPicturesExample.createCriteria().andReviewAlbumIdEqualTo(albumId);
            List<ReviewPictures> reviewPicturesList = picturesMapper.selectByExample(reviewPicturesExample);
            if (reviewPicturesList.isEmpty()) {
                productReview.setPicturesList(null);
            } else {
                productReview.setPicturesList(reviewPicturesList);
            }
            productReviewList.add(productReview);
        }
        return productReviewList;
    }

    @Override
    public Review createReview(Review newReview, List<ReviewPictures> picturesList, int userId) {
        newReview.setCreatedAt(new Date());
        newReview.setMemberId(userId);
        reviewMapper.insert(newReview);
        int reviewId = newReview.getId();
        createAlbumAndPicture(reviewId, picturesList);
        createUpdateLog(reviewId, "create review", userId);
        return newReview;
    }

    @Override
    public Review updateReview(Review updatedReview, List<ReviewPictures> picturesList, int userId) {
        updatedReview.setUpdatedAt(new Date());
        reviewMapper.updateByPrimaryKeySelective(updatedReview);

        int reviewId = updatedReview.getId();

        // TODO: change the update method, currently is delete then reinsert
        deleteAlbumAndPicture(reviewId);
        createAlbumAndPicture(reviewId, picturesList);

        createUpdateLog(reviewId, "update review", userId);

        return updatedReview;
    }

    @Override
    public void deleteReview(int reviewId, int userId) {
        reviewMapper.deleteByPrimaryKey(reviewId);
        deleteAlbumAndPicture(reviewId);
        createUpdateLog(reviewId, "delete review", userId);
    }

    private int deleteAlbumAndPicture(int reviewId) {
        ReviewAlbumExample albumExample = new ReviewAlbumExample();
        albumExample.createCriteria().andReviewIdEqualTo(reviewId);
        ReviewAlbum foundAlbum = albumMapper.selectByExample(albumExample).get(0);

        int albumId = foundAlbum.getId();

        albumMapper.deleteByPrimaryKey(albumId);

        ReviewPicturesExample picturesExample = new ReviewPicturesExample();
        picturesExample.createCriteria().andReviewAlbumIdEqualTo(albumId);
        List<ReviewPictures> picturesList = picturesMapper.selectByExample(picturesExample);

        for (ReviewPictures picture: picturesList) {
            picturesMapper.deleteByPrimaryKey(picture.getId());
        }

        return picturesList.size();
    }

    private int createAlbumAndPicture(int reviewId, List<ReviewPictures> picturesList) {
        ReviewAlbum newAlbum = new ReviewAlbum();
        newAlbum.setReviewId(reviewId);
        newAlbum.setPicCount(picturesList.size());
        newAlbum.setCreatedAt(new Date());
        albumMapper.insert(newAlbum);

        int albumId = newAlbum.getId();

        if (picturesList.isEmpty()) return 0;

        for (ReviewPictures picture: picturesList) {
            picture.setReviewAlbumId(albumId);
            picture.setCreatedAt(new Date());

            picturesMapper.insert(picture);
        }
        return picturesList.size();
    }

    private void createUpdateLog(int reviewId, String updateAction, int userId) {
        // TODO: might create another update log table just for user and one for admin
        ReviewUpdateLog updateLog = new ReviewUpdateLog();
        updateLog.setReviewId(reviewId);
        updateLog.setUpdateAction(updateAction);
        updateLog.setOperator("user id: " + userId);
        updateLog.setCreatedAt(new Date());
        updateLogMapper.insert(updateLog);
    }
}
