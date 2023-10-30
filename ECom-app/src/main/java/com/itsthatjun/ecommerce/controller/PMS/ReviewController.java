package com.itsthatjun.ecommerce.controller.PMS;

import com.itsthatjun.ecommerce.dto.PMS.ProductReview;
import com.itsthatjun.ecommerce.mbg.model.Review;
import com.itsthatjun.ecommerce.service.Messaging.ReviewMessageService;
import com.itsthatjun.ecommerce.service.PMS.implementation.ReviewServiceImpl;
import com.itsthatjun.ecommerce.service.UMS.implementation.MemberServiceImpl;
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

    private final MemberServiceImpl memberService;

    private final ReviewMessageService messageService;

    @Autowired
    public ReviewController(ReviewServiceImpl reviewService, MemberServiceImpl memberService, ReviewMessageService messageService) {
        this.reviewService = reviewService;
        this.memberService = memberService;
        this.messageService = messageService;
    }

    @GetMapping("/detail/{reviewId}")
    @ApiOperation(value = "get detail of a review")
    public ProductReview getDetailReview(@PathVariable int reviewId) {
        return reviewService.getDetailReview(reviewId);
    }

    @GetMapping("/getAllProductReview/{productId}")
    @ApiOperation(value = "get all reviews for a product")
    public List<ProductReview> getProductReviews(@PathVariable int productId) {
        return reviewService.listProductAllReview(productId);
    }

    @PostMapping("/create")
    @ApiOperation(value = "create review for a product")
    public ProductReview createProductReview(@RequestBody ProductReview newReview) {
        int userId = memberService.getCurrentUser().getId();
        messageService.sendReviewCreateMessage(newReview, userId);
        return newReview;
    }

    @PostMapping("/update")
    @ApiOperation(value = "update a review")
    public ProductReview updateProductReviews(@RequestBody ProductReview productReview) {
        int userId = memberService.getCurrentUser().getId();
        messageService.sendReviewUpdateMessage(productReview, userId);
        return productReview;
    }

    @DeleteMapping("/delete/{reviewId}")
    @ApiOperation(value = "Get product with page and size")
    public void deleteProductReviews(@PathVariable int reviewId) {
        int userId = memberService.getCurrentUser().getId();
        Review review = new Review();
        review.setId(reviewId);
        messageService.sendReviewDeleteMessage(review, userId);
    }
}
