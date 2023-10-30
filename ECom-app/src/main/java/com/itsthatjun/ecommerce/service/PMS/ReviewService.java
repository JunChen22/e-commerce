package com.itsthatjun.ecommerce.service.PMS;

import com.itsthatjun.ecommerce.dto.PMS.ProductReview;
import com.itsthatjun.ecommerce.mbg.model.Review;
import com.itsthatjun.ecommerce.mbg.model.ReviewPictures;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ReviewService {

    @ApiOperation(value = "")
    ProductReview getDetailReview(int reviewId);

    @ApiOperation(value = "")
    List<ProductReview> listProductAllReview(int productId);

    @ApiOperation(value = "")
    Review createReview(Review newReview, List<ReviewPictures> picturesList, int userId);

    @ApiOperation(value = "")
    Review updateReview(Review updatedReview, List<ReviewPictures> picturesList, int userId);

    @ApiOperation(value = "")
    void deleteReview(int reviewId, int userId);
}
