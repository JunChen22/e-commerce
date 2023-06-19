package com.itsthatjun.ecommerce.mbg.model;

import java.util.Date;

public class ProductPictures {
    private Integer id;

    private Integer productAlbumId;

    private Integer productId;

    private String filename;

    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductAlbumId() {
        return productAlbumId;
    }

    public void setProductAlbumId(Integer productAlbumId) {
        this.productAlbumId = productAlbumId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}