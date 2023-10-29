package com.itsthatjun.ecommerce.dto.event.ums;

import com.itsthatjun.ecommerce.dto.MemberDetail;
import lombok.Getter;

import java.io.Serializable;
import java.time.ZonedDateTime;

import static java.time.ZonedDateTime.now;

@Getter
public class UmsUserEvent implements Serializable {

    public enum Type {
        NEW_ACCOUNT,
        UPDATE_PASSWORD,
        UPDATE_ACCOUNT_INFO,
        UPDATE_ADDRESS,
        DELETE_ACCOUNT
    }

    private final Type eventType;
    private final MemberDetail memberDetail;
    private final ZonedDateTime eventCreatedAt;

    // Jackson needs it, (the library used for JSON serialization/deserialization)
    public UmsUserEvent() {
        this.eventType = null;
        this.memberDetail = null;
        this.eventCreatedAt = null;
    }

    public UmsUserEvent(Type eventType, MemberDetail memberDetail) {
        this.eventType = eventType;
        this.memberDetail = memberDetail;
        this.eventCreatedAt = now();
    }
}
