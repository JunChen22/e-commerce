package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;

public class ReceiveAddress {
    private Integer id;

    private BigDecimal memberId;

    private String phoneNumber;

    private String street;

    private String city;

    private String state;

    private String zipCode;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMemberId() {
        return memberId;
    }

    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}