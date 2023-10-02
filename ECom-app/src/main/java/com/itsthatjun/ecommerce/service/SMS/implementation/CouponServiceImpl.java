package com.itsthatjun.ecommerce.service.SMS.implementation;

import com.itsthatjun.ecommerce.mbg.mapper.*;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.OMS.implementation.CartItemServiceImpl;
import com.itsthatjun.ecommerce.service.SMS.CouponService;
import com.itsthatjun.ecommerce.service.UMS.implementation.MemberServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CouponServiceImpl implements CouponService {

    private static final Logger LOG = LoggerFactory.getLogger(CouponServiceImpl.class);

    private final MemberServiceImpl memberService;

    private final CartItemServiceImpl cartItemService;

    private final CouponMapper couponMapper;

    private final ProductMapper productMapper;

    private final CouponHistoryMapper couponHistoryMapper;

    private final CouponProductRelationMapper productRelationMapper;

    private final ProductSkuMapper productSkuMapper;

    private final CartItemMapper cartItemMapper;

    @Autowired
    public CouponServiceImpl(MemberServiceImpl memberService, CartItemServiceImpl cartItemService, CouponMapper couponMapper, ProductMapper productMapper, CouponHistoryMapper couponHistoryMapper, CouponProductRelationMapper productRelationMapper, ProductSkuMapper productSkuMapper, CartItemMapper cartItemMapper) {
        this.memberService = memberService;
        this.cartItemService = cartItemService;
        this.couponMapper = couponMapper;
        this.productMapper = productMapper;
        this.couponHistoryMapper = couponHistoryMapper;
        this.productRelationMapper = productRelationMapper;
        this.productSkuMapper = productSkuMapper;
        this.cartItemMapper = cartItemMapper;
    }

    @Override
    public double checkDiscount(String couponCode) {
        Member currentUser = memberService.getCurrentUser();
        int userId = currentUser.getId();

        Coupon foundCoupon = checkCoupon(couponCode);
        if (foundCoupon == null) return 0;

        List<CartItem> cartItemList = cartItemService.getUserCart();
        if (cartItemList.isEmpty()) return 0;

        Map<String, Integer> skuQuantity = new HashMap<>();
        for (CartItem cartItem : cartItemList) {
            int quantity = cartItem.getQuantity();
            String skuCode = cartItem.getProductSku();
            skuQuantity.put(skuCode, quantity);
        }
        return  getDiscountAmount(skuQuantity, foundCoupon);
    }

    private Coupon checkCoupon(String couponCode) {
        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andCodeEqualTo(couponCode);
        List<Coupon> result = couponMapper.selectByExample(couponExample);
        if (result.isEmpty())
            return null;
        return result.get(0);
    }

    private double getDiscountAmount(Map<String, Integer> skuQuantity, Coupon coupon) {
        double totalDiscount = 0;

        // check expiration
        Date startDate = coupon.getStartTime();
        Date endDate = coupon.getEndTime();
        Date currentDate = new Date();

        if (!(currentDate.after(startDate) && currentDate.before(endDate))) {
            return 0;
        }

        if (coupon.getStatus() == 0) return 0;  // not active coupon

        // check usage limit
        if (coupon.getCount() <= coupon.getUsedCount() && coupon.getUsedCount() >= coupon.getPublishCount()) {
            LOG.info("Coupon expired.");
            return 0;
        }

        // discount on 0-> all, 1 -> specific brand,  2-> specific category , 3-> specific item
        if (coupon.getCouponType() == 0) {  // whole order discount
            totalDiscount = wholeOrderDiscount(skuQuantity, coupon);
            return totalDiscount;
        }

        // TODO:  create dao and use SQL for simpler method
        // Find products affected by this coupon
        CouponProductRelationExample productRelationExample = new CouponProductRelationExample();
        productRelationExample.createCriteria().andCouponIdEqualTo(coupon.getId());
        List<CouponProductRelation> itemAffectedByCouponList = productRelationMapper.selectByExample(productRelationExample);

        for (String skuCode : skuQuantity.keySet()) {
            String itemSKuCode = skuCode;
            int quantityNeeded = skuQuantity.get(skuCode);

            ProductSkuExample productSkuStockExample = new ProductSkuExample();
            productSkuStockExample.createCriteria().andSkuCodeEqualTo(skuCode);
            ProductSku productSkuStock = productSkuMapper.selectByExample(productSkuStockExample).get(0);

            int itemId = productSkuStock.getProductId();

            for (CouponProductRelation discountItem: itemAffectedByCouponList) {
                if (discountItem.getProductSkuCode().equals(itemSKuCode)  && discountItem.getProductId() == itemId) {
                    if (coupon.getDiscountType() == 0) {// discount by amount
                        totalDiscount = totalDiscount + (coupon.getAmount().doubleValue() * quantityNeeded);
                    } else {   // discount  by percent
                        totalDiscount = totalDiscount + ((coupon.getAmount().doubleValue() * productSkuStock.getPromotionPrice().doubleValue()) / 100) * quantityNeeded;
                    }
                }
            }
        }
        return totalDiscount;
    }

    private double wholeOrderDiscount(Map<String, Integer> skuQuantity, Coupon coupon) {
        double totalDiscount = 0;
        double totalPrice = 0;
        for (String skuCode : skuQuantity.keySet()) {
            int quantityNeeded = skuQuantity.get(skuCode);

            ProductSkuExample productSkuStockExample = new ProductSkuExample();
            productSkuStockExample.createCriteria().andSkuCodeEqualTo(skuCode);
            ProductSku productSkuStock = productSkuMapper.selectByExample(productSkuStockExample).get(0);
            totalPrice += productSkuStock.getPromotionPrice().doubleValue() * quantityNeeded;
        }

        if (coupon.getDiscountType() == 0) {// discount by amount
            totalDiscount = coupon.getAmount().doubleValue();
        } else {   // discount  by percent
            totalDiscount =  ((coupon.getAmount().doubleValue() * totalPrice) / 100);
        }
        return totalDiscount;
    }

    @Override
    public void updateUsedCoupon(String code, int orderId) {
        Member currentUser = memberService.getCurrentUser();
        int userId = currentUser.getId();

        if (checkCoupon(code) == null) {
            return ;
        }

        // find and update coupon count
        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andCodeEqualTo(code);
        Coupon usedCoupon = couponMapper.selectByExample(couponExample).get(0);
        int usedCount = usedCoupon.getUsedCount() + 1;
        usedCoupon.setUsedCount(usedCount);

        couponMapper.updateByPrimaryKey(usedCoupon);

        // add used history
        CouponHistory couponHistory = new CouponHistory();
        couponHistory.setOrderId(orderId);
        couponHistory.setCouponId(usedCoupon.getId());
        couponHistory.setCode(code);
        couponHistory.setMemberId(userId);

        couponHistoryMapper.insert(couponHistory);
    }
}
