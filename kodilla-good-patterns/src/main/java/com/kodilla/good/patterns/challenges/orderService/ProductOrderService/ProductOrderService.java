package com.kodilla.good.patterns.challenges.orderService.ProductOrderService;

import com.kodilla.good.patterns.challenges.orderService.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface ProductOrderService {

    boolean order(User user, int quantity, LocalDateTime orderTime, ArrayList<String> orderList);
}
