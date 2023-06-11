package com.itsthatjun.ecommerce.service.impl;

import com.itsthatjun.ecommerce.elasticsearch.document.EsProduct;
import com.itsthatjun.ecommerce.elasticsearch.repository.EsProductRepository;
import com.itsthatjun.ecommerce.mongo.SearchEntity;
import com.itsthatjun.ecommerce.mongo.SearchRepository;
import com.itsthatjun.ecommerce.service.EsProductService;
import com.itsthatjun.ecommerce.dao.EsProductDao;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class EsProductServiceImpl implements EsProductService {

    @Autowired
    private EsProductDao productDao;

    @Autowired
    private EsProductRepository productRepository;

    @Autowired
    private SearchRepository searchRepository;


    @Override
    public int importAll() {
        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
        Iterable<EsProduct> esProductIterable = productRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int result = 0;
        while(iterator.hasNext()){
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> productList = productDao.getAllEsProductList(id);
        if(productList.size() > 0){
            EsProduct newProduct = productList.get(0);
            result = productRepository.save(newProduct);
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        if(!CollectionUtils.isEmpty(ids)){
            List<EsProduct> esProductList = new ArrayList<>();
            for(Long id: ids){
                EsProduct esproduct = new EsProduct();
                esproduct.setId(id);
                esProductList.add(esproduct);
            }
            productRepository.deleteAll(esProductList);
        }
    }

    @Override
    public List<EsProduct> search(String keyword, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        searchRepository.save(new SearchEntity(keyword, new Date()));
        return productRepository.findByNameContainingOrSubTitleContainingOrKeywordsContaining(keyword, keyword, keyword, pageable);
    }

    @Override
    public Page<EsProduct> recommend(Long id, Integer pageNum, Integer pageSize) {
        return null;
    }

    public List<EsProduct> listImportedProduct() {
        List<EsProduct> improtedProducts = productRepository.findAll();
        System.out.println("Imported " + improtedProducts.size() + " items");
        return improtedProducts;
    }
}
