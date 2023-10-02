package com.itsthatjun.ecommerce.controller.OMS;

import com.itsthatjun.ecommerce.dto.OMS.ReturnDetail;
import com.itsthatjun.ecommerce.mbg.model.ReturnRequest;
import com.itsthatjun.ecommerce.service.OMS.implementation.ReturnOrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order/return")
@Api(tags = "return related", description = "apply return and related api")
public class OrderReturnController {

    private final ReturnOrderServiceImpl returnOrderService;

    @Autowired
    public OrderReturnController(ReturnOrderServiceImpl returnOrderService) {
        this.returnOrderService = returnOrderService;
    }

    // return status,  waiting to process 0 , returning(sending) 1, complete 2, rejected(not matching reason) 3

    @GetMapping("/AllOpening")
    @ApiOperation(value = "list all return request open waiting to be approved")
    public List<ReturnRequest> listAllOpening(){
        return returnOrderService.getAllOpening();
    }

    @GetMapping("/AllReturning")
    @ApiOperation(value = "List all returns that are on their way")
    public List<ReturnRequest> listReturning(){
        return returnOrderService.getAllReturning();
    }

    @GetMapping("/AllCompleted")
    @ApiOperation(value = "List ALl completed returns")
    public List<ReturnRequest> listAllCompleted(){
        return returnOrderService.getAllCompleted();
    }

    @GetMapping("/AllRejected")
    @ApiOperation(value = "List All rejected returns requests")
    public List<ReturnRequest> listAllRejected(){
        return returnOrderService.getAllRejected();
    }

    @GetMapping("/{serialNumber}")
    @ApiOperation(value = "return a return request detail")
    public ReturnDetail getReturnRequest(@PathVariable String serialNumber){
        return returnOrderService.getReturnDetail(serialNumber);
    }

    /* TODO: combine these two update/approve/rejected
    @PostMapping("/")
    @ApiOperation(value = "")
    public OrderReturnApply approvereturn(){
        // returnOrderService.approveReturnRequest()
        // returnOrderService.rejectReturnRequest()
    }

    @PostMapping("/update")
    @ApiOperation(value = "")
    public OrderReturnApply updateReturnOrderStatus(@RequestBody OrderReturnApply returnRequest){
        return returnOrderService.updateReturnOrderStatus(returnRequest);
    }
    */

}
