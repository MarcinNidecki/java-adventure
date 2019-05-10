package com.kodilla.good.patterns.food2door.orderService;


import com.kodilla.good.patterns.food2door.products.Product;

import java.time.LocalDateTime;
import java.util.HashMap;

public class OrderRequest {

    private User user;
    private LocalDateTime orderTime;
    private HashMap<Product,Integer> orderList;

    OrderRequest(User user, LocalDateTime orderTime, HashMap<Product,Integer> orderList) {
        this.user = user;
        this.orderTime = orderTime;
        this.orderList = orderList;

    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public HashMap<Product,Integer> getOrderList() {
        return orderList;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderList=" + orderList +
                '}';
    }

}
