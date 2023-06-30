package com.itsthatjun.ecommerce.service.SMS.implementation;

import com.itsthatjun.ecommerce.dto.SMS.OnSaleRequest;
import com.itsthatjun.ecommerce.mbg.mapper.*;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.service.SMS.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesServiceimpl implements SalesService{

    private final PromotionSaleMapper promotionSaleMapper;

    private final PromotionSaleProductRelationMapper productRelationMapper;

    private final ProductSkuStockMapper productSkuStockMapper;

    private final PromotionSaleLogMapper promotionSaleLogMapper;

    private final ProductMapper productMapper;

    @Autowired
    public SalesServiceimpl(PromotionSaleMapper promotionSaleMapper, PromotionSaleProductRelationMapper productRelationMapper,
                            ProductSkuStockMapper productSkuStockMapper, PromotionSaleLogMapper promotionSaleLogMapper,
                            ProductMapper productMapper) {
        this.promotionSaleMapper = promotionSaleMapper;
        this.productRelationMapper = productRelationMapper;
        this.productSkuStockMapper = productSkuStockMapper;
        this.promotionSaleLogMapper = promotionSaleLogMapper;
        this.productMapper = productMapper;
    }

    @Override
    public List<PromotionSale> getAllPromotionalSale() {
        PromotionSaleExample saleExample = new PromotionSaleExample();
        saleExample.createCriteria().andStatusEqualTo(1);  // default active sales
        List<PromotionSale> result = promotionSaleMapper.selectByExample(saleExample);
        return result.size() > 0 ? result : null;
    }

    // 0-> not on sale; 1-> is on sale; 2-> flash sale/special sales/clarance/used item

    @Override
    public List<Product> getAllPromotionalSaleItems() {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andOnSaleStatusEqualTo(1);
        List<Product> result = productMapper.selectByExample(productExample);
        return result.size() > 0 ? result : null;
    }

    @Override
    public List<Product> getAllFlashSaleItems() {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andOnSaleStatusEqualTo(2);
        List<Product> result = productMapper.selectByExample(productExample);
        return result.size() > 0 ? result : null;
    }

    private void create(PromotionSale newSale, int productId, List<String> skuCodes) {

        Product product = productMapper.selectByPrimaryKey(productId);
        product.setOnSaleStatus(1);
        for (String skuCode : skuCodes) {
            System.out.println(skuCode);

            // find the product and sku
            ProductSkuStockExample skuStockExample = new ProductSkuStockExample();
            skuStockExample.createCriteria().andProductIdEqualTo(productId).andSkuCodeEqualTo(skuCode);
            ProductSkuStock productSkuStock = productSkuStockMapper.selectByExample(skuStockExample).get(0);

            double price = productSkuStock.getPrice().doubleValue();

            if (newSale.getDiscountType() == 0) {  // -- 0 -> by amount , 1->  by percent off
                price = price - newSale.getAmount().doubleValue();
            } else {
                price = (100 - newSale.getAmount().doubleValue())/100 * price;
            }

            if (product.getSalePrice().doubleValue() > price) product.setSalePrice(BigDecimal.valueOf(price));

            System.out.println(price);

            productSkuStock.setPromotionPrice(BigDecimal.valueOf(price));
            // TODO: need to check if it exist already
            PromotionSaleProductRelation relation = new PromotionSaleProductRelation();
            relation.setProductId(productId);
            relation.setProductSkuCode(skuCode);
            relation.setPromotionSaleId(newSale.getId());
            relation.setPromotionPrice(BigDecimal.valueOf(price));
            relation.setPromotionCount(20); // TODO: add limit(stock) per person or per set item limit for sale
            relation.setPromotionLimit(3);

            productMapper.updateByPrimaryKey(product);  // TODO: might cause error if product id don't exist
            productRelationMapper.insert(relation);
            productSkuStockMapper.updateByPrimaryKey(productSkuStock);
        }
    }

    private PromotionSale createNewSale(OnSaleRequest request) {
        PromotionSale newSale = new PromotionSale();
        newSale.setName(request.getName());
        newSale.setPromotionType(request.getPromotionType());
        newSale.setDiscountType(request.getDiscountType());
        newSale.setAmount(BigDecimal.valueOf(request.getAmount()));
        newSale.setStatus(request.getStatus());
        newSale.setStartTime(request.getStartTime());
        newSale.setEndTime(request.getEndTime());
        newSale.setCreatedAt(new Date());
        return newSale;
    }

    //  -- discount on 0-> all, 1 -> specific brand,  2-> specific category , 3-> specific item
    @Override
    public List<Product> createList(OnSaleRequest request) {
        // create promotion info
        PromotionSale newSale = createNewSale(request);

        promotionSaleMapper.insert(newSale);

        for (Product product : request.getProduct()) {
            System.out.println(product.getName() + " : "  + request.getProductIdToSkuCode().get(product.getId()));
            create(newSale, product.getId(), request.getProductIdToSkuCode().get(product.getId()));
        }
        return request.getProduct();
    }

    @Override
    public List<Product> createBrandSale(OnSaleRequest request) {

        // create promotion info
        PromotionSale newSale = createNewSale(request);
        promotionSaleMapper.insert(newSale);

        // find product list by brand id
        int brandId = request.getBrandId();

        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andBrandIdEqualTo(brandId);
        List<Product> productList =  productMapper.selectByExample(productExample);

        // using product to find sku
        for (Product product : productList) {

            int productId = product.getId();

            ProductSkuStockExample skuStockExample = new ProductSkuStockExample();
            skuStockExample.createCriteria().andProductIdEqualTo(productId);
            List<ProductSkuStock> productSkuStocks = productSkuStockMapper.selectByExample(skuStockExample);
            List<String> skuCodeList = productSkuStocks.stream()
                    .map(ProductSkuStock::getSkuCode)
                    .collect(Collectors.toList());
            create(newSale, productId, skuCodeList);
        }
        return productList;
    }

    @Override
    public List<Product> createCategorySale(OnSaleRequest request) {

        // create promotion info
        PromotionSale newSale = createNewSale(request);
        promotionSaleMapper.insert(newSale);

        // find product list by brand id
        int categoryId = request.getProductCategoryId();

        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andCategoryIdEqualTo(categoryId);
        List<Product> productList =  productMapper.selectByExample(productExample);

        // using product to find sku
        for (Product product : productList) {

            int productId = product.getId();

            ProductSkuStockExample skuStockExample = new ProductSkuStockExample();
            skuStockExample.createCriteria().andProductIdEqualTo(productId);
            List<ProductSkuStock> productSkuStocks = productSkuStockMapper.selectByExample(skuStockExample);
            List<String> skuCodeList = productSkuStocks.stream()
                    .map(ProductSkuStock::getSkuCode)
                    .collect(Collectors.toList());
            create(newSale, productId, skuCodeList);
        }
        return productList;
    }

    @Override
    public OnSaleRequest updateStatus(OnSaleRequest updateSaleRequest) {
        PromotionSaleLog newLog = new PromotionSaleLog();

        // update status

        // change price back to original price or apply the discount
        //if updateSaleRequest.getStatus() == ACCTIVE //TODO: enum
        if (updateSaleRequest.getStatus() == 0) {

        } else {

            // change discount
        }
        // TODO: could do it multiple ways, when getting prices, also need to check sale status to get the discount price
        //       or change the price no matter what and need sale status.

        return null;
    }

    @Override
    public OnSaleRequest upateSaleDate(OnSaleRequest updateSaleRequest) {

        // change date

        // update prices if past expiration date

        // TODO: need a scheduler or something to check sale dates

        return null;
    }

    @Override
    public OnSaleRequest updateSaleAmount(OnSaleRequest updateSaleRequest) {


        return null;
    }

    @Override
    public OnSaleRequest updateSaleLimt(OnSaleRequest updateSaleRequest) {


        return null;
    }

    // TODO: need something to update time to expire or disabled promotion

    @Override       // flash sale vs promotion sale
    public OnSaleRequest updateSaleType(OnSaleRequest updateSaleRequest) {
        // TODO: might cause problem when changing the status
        return null;
    }

    @Override
    public void delete(int promotionSaleId) {
        // TODO: might affect other promotion like all 10% off, need to set something like one promotion at a time.
        PromotionSale foundSale = promotionSaleMapper.selectByPrimaryKey(promotionSaleId);

        PromotionSaleProductRelationExample productRelationExample = new PromotionSaleProductRelationExample();
        productRelationExample.createCriteria().andPromotionSaleIdEqualTo(foundSale.getId());
        List<PromotionSaleProductRelation> affectedProducts = productRelationMapper.selectByExample(productRelationExample);

        for (PromotionSaleProductRelation affectedProduct: affectedProducts) {

            Product foundProduct = productMapper.selectByPrimaryKey(affectedProduct.getProductId());

            double originalPrice = foundProduct.getOriginalPrice().doubleValue();

            foundProduct.setOnSaleStatus(0);
            foundProduct.setSalePrice(BigDecimal.valueOf(originalPrice));

            ProductSkuStockExample skuStockExample = new ProductSkuStockExample();
            skuStockExample.createCriteria().andSkuCodeEqualTo(affectedProduct.getProductSkuCode())
                    .andProductIdEqualTo(foundProduct.getId());
            ProductSkuStock foundSku = productSkuStockMapper.selectByExample(skuStockExample).get(0);
            foundSku.setPromotionPrice(BigDecimal.valueOf(originalPrice));
            productSkuStockMapper.updateByPrimaryKey(foundSku);

            productMapper.updateByPrimaryKey(foundProduct);
            productRelationMapper.deleteByPrimaryKey(affectedProduct.getId());
        }
        promotionSaleMapper.deleteByPrimaryKey(promotionSaleId);
    }
}
