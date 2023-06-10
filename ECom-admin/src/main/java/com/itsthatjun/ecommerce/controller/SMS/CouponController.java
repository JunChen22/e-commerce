package com.itsthatjun.ecommerce.controller.SMS;

import com.itsthatjun.ecommerce.mbg.model.Coupon;
import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.service.SMS.implementation.CouponServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
@Api(tags = "Coupon related", description = "CRUD coupon by admin with right roles/permission")
public class CouponController {

    private final CouponServiceImpl couponService;

    @Autowired
    public CouponController(CouponServiceImpl couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/listAll")
    @ApiOperation(value = "return all working non-expired coupon")
    public List<Coupon> listAll() {
        // TODO: add default value to get only active or disabled coupon , currently is all
        List<Coupon> couponList = couponService.getAllCoupon();
        return couponList;
    }

    @GetMapping("/{couponId}")
    @ApiOperation(value = "Get coupons that works with a product")
    public Coupon list(@PathVariable int couponId) {
        return couponService.getACoupon(couponId);
    }

    @GetMapping("/product/all/{productId}")
    @ApiOperation(value = "Get coupons that works with a product")
    public List<Coupon> getCouponForProduct(@PathVariable int productId) {
        List<Coupon> couponList = couponService.getCouponForProduct(productId);
        return couponList;
    }

    @PostMapping("/create")
    @ApiOperation(value = "create a coupon")
    public Coupon create(@RequestBody Coupon coupon) {
        couponService.createCoupon(coupon);
        return coupon;
    }
    @PostMapping("/update")
    @ApiOperation(value = "update a coupon")
    public Coupon update(@RequestBody Coupon updateCoupon){
        couponService.updateCoupon(updateCoupon);
        return updateCoupon;
    }

    @DeleteMapping("/delete/{couponId}")
    @ApiOperation(value = "delete a coupon")
    public void delete(@PathVariable int couponId) {
        couponService.deleteCoupon(couponId);
    }
}
