package com.kodilla.good.patterns.food2door.orderRepository.distributorOrderRepository;

import com.kodilla.good.patterns.food2door.distributors.Distributor;
import com.kodilla.good.patterns.food2door.products.Product;

import java.time.LocalDateTime;
import java.util.HashMap;

public interface DistributorOrderRepository {

    void createOrder(CompanyProfile companyProfile, LocalDateTime orderTime, HashMap<Distributor,HashMap<Product,Integer>> orderList);
}
