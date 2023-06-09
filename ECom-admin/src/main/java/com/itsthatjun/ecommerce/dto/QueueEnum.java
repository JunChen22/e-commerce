package com.itsthatjun.ecommerce.dto;

/**
 * Created by Jun Chen on 5/6/21.
 */
public enum QueueEnum {

    QUEUE_ORDER_CANCEL("order.direct", ".order.cancel", "order.cancel"),

    QUEUE_TTL_ORDER_CANCEL("order.direct.ttl", "order.cancel.ttl", "order.cancel.ttl");

    private String exchange;
    private String name;
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }
}
