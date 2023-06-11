package com.itsthatjun.ecommerce.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "searchHistory")
public class SearchEntity {

    @Id
    private String id;

    @Version
    private Integer version;

    private String keyword;
    private Date date;

    public SearchEntity() {
    }

    public SearchEntity(String keyword, Date date) {
        this.keyword = keyword;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
