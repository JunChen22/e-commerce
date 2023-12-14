package com.itsthatjun.ecommerce.dto.event.pms;

import com.itsthatjun.ecommerce.mbg.model.Review;
import com.itsthatjun.ecommerce.mbg.model.ReviewPictures;
import lombok.Getter;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

import static java.time.ZonedDateTime.now;

@Getter
public class PmsReviewEvent implements Serializable {

    public enum Type {
        CREATE_REVIEW,  // update stock after order generated, locked stock increase
        UPDATE_REVIEW,  // update after payment,  unlock locked stock and update stock.
        DELETE_REVIEW    // unlock returned or unpaid orders stock
    }

    private final Type eventType;
    private final int userId;
    private final Review review;

    private final List<ReviewPictures> picturesList;
    private final ZonedDateTime eventCreatedAt;

    // Jackson needs it, (the library used for JSON serialization/deserialization)
    public PmsReviewEvent() {
        this.eventType = null;
        this.userId = 0;
        this.review = null;
        this.picturesList = null;
        this.eventCreatedAt = null;
    }

    public PmsReviewEvent(Type eventType, int userId, Review review, List<ReviewPictures> picturesList) {
        this.eventType = eventType;
        this.userId = userId;
        this.review = review;
        this.picturesList = picturesList;
        this.eventCreatedAt = now();
    }
}
