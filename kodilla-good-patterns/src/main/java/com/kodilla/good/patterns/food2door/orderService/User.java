package com.kodilla.good.patterns.food2door.orderService;

public class User {

    private String userName;
    private String userMail;

    public User(String userName, String userMail) {
        this.userName = userName;
        this.userMail = userMail;
    }

    String getUserName() {
        return userName;
    }

    public String getUserMail() {
        return userMail;
    }

}


