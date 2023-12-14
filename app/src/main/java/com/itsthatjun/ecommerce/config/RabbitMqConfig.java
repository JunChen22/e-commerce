package com.itsthatjun.ecommerce.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${queue.OMS.order}")
    private String orderQueue;

    @Value("${queue.OMS.orderComplete}")
    private String orderCompleteQueue;

    @Value("${queue.OMS.orderDelayedCancel}")
    private String orderDelayedCancelQueue;

    @Value("${queue.OMS.cart}")
    private String cartQueue;

    @Value("${queue.OMS.return}")
    private String returnQueue;

    @Value("${queue.OMS.returnDelayedRejection}")
    private String returnDelayedRejectionQueue;

    @Value("${queue.PMS.review}")
    private String reviewQueue;

    @Value("${queue.UMS.user}")
    private String userQueue;

    // TODO: might add a exchange. currently is just direct default exchange and to queues

    @Bean
    public Queue orderQueue() {
        return new Queue(orderQueue);
    }

    @Bean
    public Queue orderCompleteQueue() {
        return new Queue(orderCompleteQueue);
    }

    @Bean
    public Queue orderDelayedCancelQueue() {
        return QueueBuilder.durable(orderDelayedCancelQueue)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", "orderComplete")
                .withArgument("x-message-ttl", 120000)
                .build();
    }

    @Bean
    public Queue cartQueue() {
        return new Queue(cartQueue);
    }

    @Bean
    public Queue returnQueue() {
        return new Queue(returnQueue);
    }

    @Bean
    public Queue returnDelayedRejectionQueue() {
        return QueueBuilder.durable(returnDelayedRejectionQueue)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", "return")
                .withArgument("x-message-ttl", 120000)
                .build();
    }

    @Bean
    public Queue reviewQueue() {
        return new Queue(reviewQueue);
    }

    @Bean
    public Queue userQueue() {
        return new Queue(userQueue);
    }
}
