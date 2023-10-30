package com.itsthatjun.ecommerce.controller.OMS;

import com.itsthatjun.ecommerce.dto.ReturnParam;
import com.itsthatjun.ecommerce.mbg.model.ReturnRequest;
import com.itsthatjun.ecommerce.service.Messaging.ReturnMessageService;
import com.itsthatjun.ecommerce.service.OMS.implementation.ReturnOrderServiceImpl;
import com.itsthatjun.ecommerce.service.UMS.implementation.MemberServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/return")
@Api(tags = "return related", description = "apply return and related api")
public class ReturnController {

    private final ReturnOrderServiceImpl returnOrderService;

    private final MemberServiceImpl memberService;

    private final ReturnMessageService messageService;

    @Autowired
    public ReturnController(ReturnOrderServiceImpl returnOrderService, MemberServiceImpl memberService, ReturnMessageService messageService) {
        this.returnOrderService = returnOrderService;
        this.memberService = memberService;
        this.messageService = messageService;
    }

    @GetMapping("/status/{orderSn}")
    @ApiOperation(value = "check status of the return request")
    public ReturnRequest checkStatus(@PathVariable String orderSn) {
        int userId = memberService.getCurrentUser().getId();
        return returnOrderService.getStatus(orderSn, userId);
    }

    @PostMapping("/apply")
    @ApiOperation(value = "Apply for return item, waiting for admin approve")
    public ReturnParam applyForReturn(@RequestBody ReturnParam returnParam) {
        int userId = memberService.getCurrentUser().getId();
        messageService.sendReturnRequestApplyMessage(returnParam, userId);
        return returnParam;
    }

    @PostMapping("/update")
    @ApiOperation(value = "change detail about return or return reason")
    public ReturnParam updateReturn(@RequestBody ReturnParam returnParam) {
        int userId = memberService.getCurrentUser().getId();
        messageService.sendReturnRequestUpdateMessage(returnParam, userId);
        return returnParam;
    }

    @DeleteMapping("/cancel")
    @ApiOperation(value = "change detail about return or return reason")
    public void cancelReturn(@RequestParam String orderSn) {
        int userId = memberService.getCurrentUser().getId();
        ReturnRequest returnRequest = new ReturnRequest();
        returnRequest.setOrderSn(orderSn);
        ReturnParam returnParam = new ReturnParam();
        returnParam.setReturnRequest(returnRequest);
        messageService.sendReturnRequestCancelMessage(returnParam, userId);
    }
}
