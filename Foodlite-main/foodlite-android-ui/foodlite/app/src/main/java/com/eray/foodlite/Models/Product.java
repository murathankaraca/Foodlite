package com.eray.foodlite.Models;

public class Product {
    private int productId;
    private String productName;
    private Provider productProvider;
    private double price;
    private String productType;

    public Product(int productId, String productName, Provider productProvider, double price, String productType) {
        this.productId = productId;
        this.productName = productName;
        this.productProvider = productProvider;
        this.price = price;
        this.productType = productType;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Provider getProductProvider() {
        return productProvider;
    }

    public void setProductProvider(Provider productProvider) {
        this.productProvider = productProvider;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

}
