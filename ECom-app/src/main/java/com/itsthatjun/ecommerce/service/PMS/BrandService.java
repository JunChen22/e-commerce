package com.itsthatjun.ecommerce.service.PMS;

import com.itsthatjun.ecommerce.mbg.model.Brand;
import com.itsthatjun.ecommerce.mbg.model.Product;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public interface BrandService {

    @ApiModelProperty(value = "")
    List<Brand> listAllBrand();

    @ApiModelProperty(value = "")
    List<Brand> listBrand(int pageNum, int pageSize);

    @ApiModelProperty(value = "")
    List<Product> listAllBrandProduct(int brandId);

    @ApiModelProperty(value = "")
    Brand getBrand(int id);
}
