package com.kodilla.good.patterns.challenges.orderService;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderRequest {

    private User user;
    private int quantity;
    private LocalDateTime orderTime;
    private ArrayList<String> orderList;

    OrderRequest(User user, int quantity, LocalDateTime orderTime, ArrayList<String> orderList) {
        this.user = user;
        this.quantity = quantity;
        this.orderTime = orderTime;
        this.orderList = orderList;

    }

    public User getUser() {
        return user;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }


    public ArrayList<String> getOrderList() {
        return orderList;
    }
}
