package com.itsthatjun.ecommerce.service.SMS;

import com.itsthatjun.ecommerce.mbg.model.Brand;
import com.itsthatjun.ecommerce.mbg.model.Product;

import java.util.Date;
import java.util.List;

public interface SalesService {

    // 0-> not on sale; 1-> is on sale; 2-> flash sale/special sales/clarance/used item
    // promotional sale and flash sale is similar

    // get all promotion/"normal" items on sale
    List<Product> getAllPromotionalSale();

    // get all sales items
    List<Product> getAllFlashSale();

    // get detail of specific item
    Product getProduct();

    // create
    Product create(Product product, Date saleEnd);

    Product createBrandSale(String brandName, Date saleEnd);

    Product createCategorySale(String categoryName, Date saleEnd);

    // update
    Product update(Product updateProduct);

    // delete
    Product delete(Product product);
}
