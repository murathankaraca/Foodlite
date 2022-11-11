package com.eray.foodlite.Models;

public class User {
    protected int userId;
    protected String userName;
    protected String name;
    protected String lastName;
    //
    protected String userType;

    User(int id, String username, String name, String lastname) {
        this.userId = id;
        this.userName = username;
        this.name = name;
        this.lastName = lastname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
