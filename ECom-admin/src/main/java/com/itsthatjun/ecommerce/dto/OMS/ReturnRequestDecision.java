package com.itsthatjun.ecommerce.dto.OMS;

import com.itsthatjun.ecommerce.mbg.model.ReturnItem;
import com.itsthatjun.ecommerce.mbg.model.ReturnReasonPictures;
import com.itsthatjun.ecommerce.mbg.model.ReturnRequest;
import lombok.Data;

import java.util.List;

@Data
public class ReturnRequestDecision {

    public enum Status {
        WAITING_TO_PROCESS,
        APPROVED, // RETURNING_ITEM_TRANSIT
        REJECTED,
        COMPLETED_RETURN
    }

    private final Status status;
    private final ReturnRequest returnRequest;
    private final List<ReturnItem> returnItemList;
    private final List<ReturnReasonPictures> picturesList;
    private final String reason;
}