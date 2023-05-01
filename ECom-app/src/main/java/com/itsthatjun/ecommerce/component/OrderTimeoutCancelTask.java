package com.itsthatjun.ecommerce.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Jun Chen on 5/6/21.
 */
@Component
public class OrderTimeoutCancelTask {

    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder(){
        System.out.println("ordered to cancel order");
    }
}
