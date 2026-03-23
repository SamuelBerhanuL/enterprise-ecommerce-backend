package com.enterprise.ecommerce.dto;

public class OrderRequest {

    private String userId;
    private String productId;

    public OrderRequest(){}

    public String getUserId() {
        return userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
