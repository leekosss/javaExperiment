package com.leekos.model;


/**
 * 单元格类，有两种状态，有牌、无牌
 */
public class Cell {
    private Integer status;  // 状态：是否有牌
    private Brand brand;    // 牌对象

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
