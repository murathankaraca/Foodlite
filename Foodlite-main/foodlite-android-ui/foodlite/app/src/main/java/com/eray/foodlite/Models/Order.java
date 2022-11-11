package com.eray.foodlite.Models;

import java.util.Calendar;

public class Order {
    private int orderId;
    private User orderedBy;
    private Calendar orderDate;
    private Product orderedProduct;
    private Payment orderPayment;

    public Order(int orderId, User orderedBy, Calendar orderDate, Product orderedProduct, Payment orderPayment) {
        this.orderId = orderId;
        this.orderedBy = orderedBy;
        this.orderDate = orderDate;
        this.orderedProduct = orderedProduct;
        this.orderPayment = orderPayment;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(User orderedBy) {
        this.orderedBy = orderedBy;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Product getOrderedProduct() {
        return orderedProduct;
    }

    public void setOrderedProduct(Product orderedProduct) {
        this.orderedProduct = orderedProduct;
    }

    public Payment getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(Payment orderPayment) {
        this.orderPayment = orderPayment;
    }
}
