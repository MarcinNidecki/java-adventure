package com.kodilla.good.patterns.challenges.orderService;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderRequestRetrieve {

    public OrderRequest  retrieve() {

        User user = new User("Tom","tom@gmail.com");
        int quantity =3;
        LocalDateTime orderTime = LocalDateTime.of(2019,5,8, 20,12,12,120);
        ArrayList<String> orderList = new ArrayList<>();
        orderList.add("Tomato");
        orderList.add("Milk");

        return  new OrderRequest(user, quantity,orderTime, orderList);
    }
}
