package com.itsthatjun.ecommerce.mbg.model;

import java.io.Serializable;

public class MemberIcon implements Serializable {
    private Integer id;

    private Integer memberId;

    private String filename;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}