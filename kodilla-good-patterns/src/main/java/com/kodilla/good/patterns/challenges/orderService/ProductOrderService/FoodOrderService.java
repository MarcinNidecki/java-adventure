package com.kodilla.good.patterns.challenges.orderService.ProductOrderService;

import com.kodilla.good.patterns.challenges.orderService.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FoodOrderService implements ProductOrderService {
    @Override
    public boolean order(User user, int quantity, LocalDateTime orderTime, ArrayList<String> orderList) {
        System.out.println(user.getUserName() + " ordering :  " + orderList.toString());
        return true;
    }
}
