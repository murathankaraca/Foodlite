package com.eray.foodlite.Models;

public class Address {
    private int addressId;
    private String fullAddress;

    public Address(int addressId, String fullAddress) {
        this.addressId = addressId;
        this.fullAddress = fullAddress;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
