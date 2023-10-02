package com.itsthatjun.ecommerce.service.PMS.implementation;

import com.github.pagehelper.PageHelper;
import com.itsthatjun.ecommerce.mbg.mapper.ProductMapper;
import com.itsthatjun.ecommerce.mbg.mapper.ProductSkuMapper;
import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.mbg.model.ProductExample;
import com.itsthatjun.ecommerce.mbg.model.ProductSku;
import com.itsthatjun.ecommerce.mbg.model.ProductSkuExample;
import com.itsthatjun.ecommerce.service.PMS.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductMapper productMapper;

    private final ProductSkuMapper skuMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper, ProductSkuMapper skuMapper) {
        this.productMapper = productMapper;
        this.skuMapper = skuMapper;
    }

    @Override
    public List<Product> listAllProduct() {
        return productMapper.selectByExample(new ProductExample());
    }

    @Override
    public List<Product> listProduct(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return productMapper.selectByExample(new ProductExample());
    }

    @Override
    public Product getProduct(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    public void updatePurchase(Map<String, Integer> skuQuantity) {

        Set<String> skuSet = skuQuantity.keySet();

        for (String sku : skuSet) {
            ProductSkuExample skuExample = new ProductSkuExample();
            skuExample.createCriteria().andSkuCodeEqualTo(sku);
            List<ProductSku> skuList = skuMapper.selectByExample(skuExample);

            if (skuList.isEmpty()) throw new RuntimeException("Unable to find product with SKU: " + sku);

            ProductSku skuProduct = skuList.get(0);

            int currentLockStock = skuProduct.getLockStock();
            int quantityPurchased = skuQuantity.get(sku);
            skuProduct.setLockStock(currentLockStock + quantityPurchased);

            skuMapper.updateByPrimaryKey(skuProduct);
        }
    }

    public void updatePurchasePayment(Map<String, Integer> skuQuantity) {
        Set<String> skuSet = skuQuantity.keySet();

        for (String sku : skuSet) {
            ProductSkuExample skuExample = new ProductSkuExample();
            skuExample.createCriteria().andSkuCodeEqualTo(sku);
            List<ProductSku> skuList = skuMapper.selectByExample(skuExample);

            if (skuList.isEmpty()) throw new RuntimeException("Unable to find product with SKU: " + sku);

            ProductSku skuProduct = skuList.get(0);

            int productId = skuProduct.getProductId();
            int currentSkuStock = skuProduct.getStock();
            int currentSkuLockStock = skuProduct.getLockStock();
            int quantityPurchased = skuQuantity.get(sku);

            skuProduct.setLockStock(currentSkuLockStock - quantityPurchased);
            skuProduct.setStock(currentSkuStock - quantityPurchased);

            skuMapper.updateByPrimaryKey(skuProduct);

            Product foundProduct = productMapper.selectByPrimaryKey(productId);

            int currentStock = foundProduct.getStock();
            foundProduct.setStock(currentStock - quantityPurchased);
            productMapper.updateByPrimaryKey(foundProduct);
        }
    }

    public void updateReturn(Map<String, Integer> skuQuantity) {
        Set<String> skuSet = skuQuantity.keySet();

        for (String sku : skuSet) {
            ProductSkuExample skuExample = new ProductSkuExample();
            skuExample.createCriteria().andSkuCodeEqualTo(sku);
            List<ProductSku> skuList = skuMapper.selectByExample(skuExample);

            if (skuList.isEmpty()) throw new RuntimeException("Unable to find product with SKU: " + sku);

            ProductSku skuProduct = skuList.get(0);

            int productId = skuProduct.getProductId();
            int currentSkuStock = skuProduct.getStock();
            int quantityReturned = skuQuantity.get(sku);

            skuProduct.setStock(currentSkuStock + quantityReturned);

            skuMapper.updateByPrimaryKey(skuProduct);

            Product foundProduct = productMapper.selectByPrimaryKey(productId);

            int currentStock = foundProduct.getStock();
            foundProduct.setStock(currentStock + quantityReturned);
            productMapper.updateByPrimaryKey(foundProduct);
        }
    }

    public void updateFailPayment(Map<String, Integer> skuQuantity) {
        Set<String> skuSet = skuQuantity.keySet();

        for (String sku : skuSet) {
            ProductSkuExample skuExample = new ProductSkuExample();
            skuExample.createCriteria().andSkuCodeEqualTo(sku);
            List<ProductSku> skuList = skuMapper.selectByExample(skuExample);

            if (skuList.isEmpty()) throw new RuntimeException("Unable to find product with SKU: " + sku);

            ProductSku skuProduct = skuList.get(0);

            int currentLockStock = skuProduct.getLockStock();
            int quantityFreed = skuQuantity.get(sku);
            skuProduct.setLockStock(currentLockStock - quantityFreed);

            skuMapper.updateByPrimaryKey(skuProduct);
        }
    }
}
