package com.itsthatjun.ecommerce.dto.event.oms;

import com.itsthatjun.ecommerce.dto.ReturnParam;
import com.itsthatjun.ecommerce.mbg.model.ReturnRequest;
import lombok.Getter;

import java.io.Serializable;
import java.time.ZonedDateTime;

import static java.time.ZonedDateTime.now;

@Getter
public class OmsReturnEvent implements Serializable {

    public enum Type {
        APPLY,
        UPDATE,
        CANCEL,
        REJECT
    }

    private final Type eventType;
    private final int userId;
    private final ReturnParam returnParam;
    private final ZonedDateTime eventCreatedAt;

    // Jackson needs it, (the library used for JSON serialization/deserialization)
    public OmsReturnEvent() {
        this.eventType = null;
        this.userId = 0;
        this.returnParam = null;
        this.eventCreatedAt = null;
    }

    public OmsReturnEvent(Type eventType, int userId, ReturnParam returnParam) {
        this.eventType = eventType;
        this.userId = userId;
        this.returnParam = returnParam;
        this.eventCreatedAt = now();
    }
}
