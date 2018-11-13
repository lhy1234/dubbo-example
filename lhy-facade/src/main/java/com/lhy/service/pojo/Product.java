package com.lhy.service.pojo;

import java.io.Serializable;

public class Product implements Serializable {

    private Integer id;

    private String productName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
