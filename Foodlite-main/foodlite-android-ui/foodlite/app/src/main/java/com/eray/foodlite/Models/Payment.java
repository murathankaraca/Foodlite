package com.eray.foodlite.Models;

public class Payment {
    private int paymentId;
    private long payment;
    private String cardNumber;

    public Payment(int paymentId, long payment, String cardNumber) {
        this.paymentId = paymentId;
        this.payment = payment;
        this.cardNumber = cardNumber;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public long getPayment() {
        return payment;
    }

    public void setPayment(long payment) {
        this.payment = payment;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
