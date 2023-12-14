package com.itsthatjun.ecommerce.controller.PMS;


import com.itsthatjun.ecommerce.mbg.model.Review;
import com.itsthatjun.ecommerce.service.PMS.ReviewService;
import com.itsthatjun.ecommerce.service.PMS.implementation.ReviewServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@Api(tags = "Product related", description = "CRUD a specific product reviews")
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    @Autowired
    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/getAllProductReview/{productId}")
    @ApiOperation(value = "get all reviews for a product")
    public List<Review> getProductReviews(@PathVariable int productId) {
        return reviewService.listProductAllReview(productId);
    }

    @GetMapping("/getAllReviewByUser/{id}")
    @ApiOperation(value = "get all reviews made a user")
    public List<Review> getProductReviewsByUser(@PathVariable int id) {
        return reviewService.listAllReviewByUser(id);
    }

    @PostMapping("/create")
    @ApiOperation(value = "create review for a product")
    public Review createProductReview(@RequestBody Review review) {
        // TODO: review created time did not create automatically
        reviewService.createReview(review);
        return review;
    }

    @PostMapping("/update")
    @ApiOperation(value = "update a review")
    public Review updateProductReviews(@RequestBody Review updatedreview) {
        reviewService.updateReview(updatedreview);
        return updatedreview;
    }

    @DeleteMapping("/delete/{reviewId}")
    @ApiOperation(value = "Get product with page and size")
    public void deleteProductReviews(@PathVariable int reviewId) {
        reviewService.deleteReview(reviewId);
    }
}
