package com.kodilla.good.patterns.food2door.orderRepository.clientOrderRepository;


import com.kodilla.good.patterns.food2door.orderService.User;
import com.kodilla.good.patterns.food2door.products.Product;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ClientTxtOrderRepository implements ClientOrderRepository {

    @Override
    public void createOrder(User user, LocalDateTime orderTime,HashMap<Product, Integer> orderList) {

    }
}
