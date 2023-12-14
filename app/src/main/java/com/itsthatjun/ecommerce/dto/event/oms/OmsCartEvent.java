package com.itsthatjun.ecommerce.dto.event.oms;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import com.itsthatjun.ecommerce.mbg.model.CartItem;
import lombok.Getter;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

import static java.time.ZonedDateTime.now;

@Getter
public class OmsCartEvent implements Serializable {

    public enum Type {
        ADD_ONE,
        UPDATE,
        DELETE,
        CLEAR
    }

    private final Type eventType;
    private final Integer userId;
    private final CartItem cartItem;
    private final ZonedDateTime eventCreatedAt;

    // Jackson needs it, (the library used for JSON serialization/deserialization)
    public OmsCartEvent() {
        this.eventType = null;
        this.userId = null;
        this.cartItem = null;
        this.eventCreatedAt = null;
    }

    public OmsCartEvent(Type eventType, Integer userId, CartItem cartItem) {
        this.eventType = eventType;
        this.userId = userId;
        this.cartItem = cartItem;
        this.eventCreatedAt = now();
    }
}