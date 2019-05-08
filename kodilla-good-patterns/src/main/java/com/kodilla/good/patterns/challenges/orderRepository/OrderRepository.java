package com.kodilla.good.patterns.challenges.orderRepository;

import com.kodilla.good.patterns.challenges.orderService.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface OrderRepository {

    void createOrder(User user, int quantity, LocalDateTime orderTime, ArrayList<String> orderList);
}
