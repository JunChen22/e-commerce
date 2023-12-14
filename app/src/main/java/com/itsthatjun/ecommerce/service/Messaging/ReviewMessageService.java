package com.itsthatjun.ecommerce.service.Messaging;

import com.itsthatjun.ecommerce.dto.PMS.ProductReview;
import com.itsthatjun.ecommerce.dto.event.pms.PmsReviewEvent;
import com.itsthatjun.ecommerce.mbg.model.Review;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.itsthatjun.ecommerce.dto.event.pms.PmsReviewEvent.Type.*;

@Service
public class ReviewMessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendReviewCreateMessage(ProductReview newReview, int userId) {
        PmsReviewEvent event = new PmsReviewEvent(CREATE_REVIEW, userId, newReview.getReview(), newReview.getPicturesList());
        rabbitTemplate.convertAndSend("", "review", event);
    }

    public void sendReviewUpdateMessage(ProductReview newReview, int userId) {
        PmsReviewEvent event = new PmsReviewEvent(UPDATE_REVIEW, userId, newReview.getReview(), newReview.getPicturesList());
        rabbitTemplate.convertAndSend("", "review", event);
    }

    public void sendReviewDeleteMessage(Review review, int userId) {
        PmsReviewEvent event = new PmsReviewEvent(DELETE_REVIEW, userId, review, null);
        rabbitTemplate.convertAndSend("", "review", event);
    }
}
