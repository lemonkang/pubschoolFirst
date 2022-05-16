package com.kanghao.eduservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
private String testId;
private Boolean isPriceempty;
private BigDecimal testPrice;
private String testFood;
private LocalDateTime gmtCreate;
private LocalDateTime gmtModified;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public Boolean getPriceempty() {
        return isPriceempty;
    }

    public void setPriceempty(Boolean priceempty) {
        isPriceempty = priceempty;
    }

    public BigDecimal getTestPrice() {
        return testPrice;
    }

    public void setTestPrice(BigDecimal testPrice) {
        this.testPrice = testPrice;
    }

    public String getTestFood() {
        return testFood;
    }

    public void setTestFood(String testFood) {
        this.testFood = testFood;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}
