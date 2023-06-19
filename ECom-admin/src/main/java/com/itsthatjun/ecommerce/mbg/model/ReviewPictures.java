package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;
import java.util.Date;

public class ReviewPictures {
    private Integer id;

    private BigDecimal reviewAlbumId;

    private String filename;

    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getReviewAlbumId() {
        return reviewAlbumId;
    }

    public void setReviewAlbumId(BigDecimal reviewAlbumId) {
        this.reviewAlbumId = reviewAlbumId;
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