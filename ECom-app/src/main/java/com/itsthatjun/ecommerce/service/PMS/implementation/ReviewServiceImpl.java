package com.itsthatjun.ecommerce.service.PMS.implementation;

import com.itsthatjun.ecommerce.mbg.mapper.ReviewMapper;
import com.itsthatjun.ecommerce.mbg.model.Review;
import com.itsthatjun.ecommerce.mbg.model.ReviewExample;
import com.itsthatjun.ecommerce.service.PMS.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewServiceImpl(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    @Override
    public List<Review> listProductAllReview(int productId) {
        ReviewExample example = new ReviewExample();
        example.createCriteria().andProductIdEqualTo(productId);

        List<Review> productReviews = reviewMapper.selectByExample(example);
        return productReviews;
    }

    @Override
    public int createReview(Review review) {
        review.setMemberId(review.getMemberId());
        review.setProductId(review.getProductId());
        int status = reviewMapper.insert(review);
        return status;
    }

    @Override
    public int updateReview(Review updatedReview) {
        ReviewExample example = new ReviewExample();
        example.createCriteria().andIdEqualTo(updatedReview.getId());
        // TODO: add update time
        //updatedReview.setUpdatedTime(new Date());
        int status = reviewMapper.updateByExample(updatedReview, example);

        return status;
    }

    @Override
    public int deleteReview(int reviewId) {
        int status = reviewMapper.deleteByPrimaryKey(reviewId);
        return status;
    }
}
