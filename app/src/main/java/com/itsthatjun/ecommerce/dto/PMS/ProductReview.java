package com.itsthatjun.ecommerce.dto.PMS;

import com.itsthatjun.ecommerce.mbg.model.Review;
import com.itsthatjun.ecommerce.mbg.model.ReviewPictures;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductReview implements Serializable {
    private Review review;
    private int albumId;
    private List<ReviewPictures> picturesList;
}
