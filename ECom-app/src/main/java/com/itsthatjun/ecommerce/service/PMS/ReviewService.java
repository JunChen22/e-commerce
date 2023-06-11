package com.itsthatjun.ecommerce.service.PMS;

import com.itsthatjun.ecommerce.mbg.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> listProductAllReview(int productId);

    int createReview( Review review);

    int updateReview(Review updatedReview);

    int deleteReview(int reviewId);
}
