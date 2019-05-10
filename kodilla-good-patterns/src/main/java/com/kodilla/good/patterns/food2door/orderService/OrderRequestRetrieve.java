package com.kodilla.good.patterns.food2door.orderService;


import com.kodilla.good.patterns.food2door.products.Milk;
import com.kodilla.good.patterns.food2door.products.Orange;
import com.kodilla.good.patterns.food2door.products.Product;
import com.kodilla.good.patterns.food2door.products.Tomato;

import java.time.LocalDateTime;
import java.util.HashMap;

public class OrderRequestRetrieve {


    public OrderRequest  retrieve() {

        User user = new User("Tom","tom@gmail.com");
        LocalDateTime orderTime = LocalDateTime.of(2019,5,8, 20,12,12,120);
        HashMap<Product,Integer> orderList = new HashMap<>();
        orderList.put(new Milk(),3);
        orderList.put(new Tomato(),2);
        return  new OrderRequest(user,orderTime, orderList);
    }

    public OrderRequest  retrieve2() {

        User user = new User("John","jphm@wp.com");
        LocalDateTime orderTime = LocalDateTime.of(2018,5,8, 20,12,12,120);
        HashMap<Product,Integer> orderList = new HashMap<>();
        orderList.put(new Milk(),1);
        orderList.put(new Orange(),1);
        return  new OrderRequest(user,orderTime, orderList);
    }

}
