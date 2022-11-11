package com.eray.foodlite.Models;

public class Profile extends User {
    private String password;
    private String email;
    private String phoneNumber;
    private String address;

    //
    private String joinDate;

    public Profile(int id, String username, String name, String lastname, String password, String email, String phoneNumber, String joinDate) {
        super(id, username, name, lastname);
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.joinDate = joinDate;
    }

    public Profile(int id, String username, String name, String lastname, String password, String email, String phoneNumber, String joinDate, String address) {
        super(id, username, name, lastname);
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.joinDate = joinDate;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
