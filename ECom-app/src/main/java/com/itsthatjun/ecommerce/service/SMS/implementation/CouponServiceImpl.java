package com.itsthatjun.ecommerce.service.SMS.implementation;

import com.itsthatjun.ecommerce.exceptions.PMS.ProductException;
import com.itsthatjun.ecommerce.mbg.mapper.*;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.SMS.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Service
public class CouponServiceImpl implements CouponService {

    private final CouponMapper couponMapper;
    private final ProductMapper productMapper;
    private final CouponHistoryMapper couponHistoryMapper;
    private final CouponProductRelationMapper productRelationMapper;
    private final ProductSkuStockMapper skuStockMapper;

    @Autowired
    public CouponServiceImpl(CouponMapper couponMapper, ProductMapper productMapper, CouponHistoryMapper couponHistoryMapper,
                             CouponProductRelationMapper productRelationMapper, ProductSkuStockMapper skuStockMapper) {
        this.couponMapper = couponMapper;
        this.productMapper = productMapper;
        this.couponHistoryMapper = couponHistoryMapper;
        this.productRelationMapper = productRelationMapper;
        this.skuStockMapper = skuStockMapper;
    }

    @Override
    public Coupon checkCoupon(String couponCode) {
        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andCodeEqualTo(couponCode);
        List<Coupon> result = couponMapper.selectByExample(couponExample);
        if (result.size() == 0)
            return null;
        System.out.println(result.get(0).getName());
        return result.get(0);
    }

    // -- discount on 0-> all, 1 -> specific brand, 2-> specific item
    @Override
    public List<Coupon> getCouponForProduct(int productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product == null)
            throw new ProductException("Can't find product : " + productId);

        String productName = product.getName();
        String brandName = product.getBrandName();

        CouponExample example = new CouponExample();
        // coupon that have product name, brand name, or all product in name
        example.createCriteria().andNameLike("%" + productName + "%");
        example.or().andNameLike("%" + brandName + "%");
        example.or().andNameLike("%" + "all product" + "%");
        example.or().andCouponTypeEqualTo(0);
        return couponMapper.selectByExample(example);
    }

    @Override
    public void updateUsedCoupon(String code, int orderId, int memberId) {
        if (checkCoupon(code) == null) {
            return ;
        }

        // find and update coupon count
        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andCodeEqualTo(code);
        Coupon usedCoupon = couponMapper.selectByExample(couponExample).get(0);
        int usedCount = usedCoupon.getUsedCount() - 1;
        usedCoupon.setUsedCount(usedCount);

        couponMapper.updateByPrimaryKey(usedCoupon);

        // add used history
        CouponHistory couponHistory = new CouponHistory();
        couponHistory.setOrderId(orderId);
        couponHistory.setCouponId(usedCoupon.getId());
        couponHistory.setCode(code);
        couponHistory.setMemberId(memberId);

        couponHistoryMapper.insert(couponHistory);
    }

    @Override
    public double getDiscountAmount(List<OrderItem> items, String couponCode) {

        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andCodeEqualTo(couponCode);
        Coupon coupon = couponMapper.selectByExample(couponExample).get(0);

        double totalDiscount = 0;

        if (coupon == null) return 0;

        // TODO:  create dao and use SQL for simpler method
        CouponProductRelationExample productRelationExample = new CouponProductRelationExample();
        productRelationExample.createCriteria().andCouponIdEqualTo(coupon.getId());
        List<CouponProductRelation> itemAffectedByCouponList = productRelationMapper.selectByExample(productRelationExample);

        for (OrderItem item : items) {
            String itemSKuCode = item.getProductSkuCode();
            int itemId = item.getProductId();
            for (CouponProductRelation discountItem: itemAffectedByCouponList) {
                if (discountItem.getProductSkuCode().equals(itemSKuCode)  && discountItem.getProductId() == itemId) {
                    ProductSkuStockExample skuStockExample = new ProductSkuStockExample();
                    skuStockExample.createCriteria().andSkuCodeEqualTo(itemSKuCode).andProductIdEqualTo(itemId);
                    ProductSkuStock productSku = skuStockMapper.selectByExample(skuStockExample).get(0);

                    if (coupon.getDiscountType() == 0) {// discount by amount
                        totalDiscount = totalDiscount + (coupon.getAmount().doubleValue() * item.getProductQuantity());
                    } else {   // discount  by percent
                        totalDiscount = totalDiscount + ((coupon.getAmount().doubleValue() * productSku.getPromotionPrice().doubleValue()) / 100) * item.getProductQuantity();
                    }
                }
            }
        }

        // TODO: ensure coupon within expiration date and start date

        return totalDiscount;
    }
}
