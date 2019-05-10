package com.kodilla.good.patterns.food2door.orderService;

import com.kodilla.good.patterns.food2door.distributors.Distributor;
import com.kodilla.good.patterns.food2door.orderRepository.distributorOrderRepository.DistributorOrderRepository;
import com.kodilla.good.patterns.food2door.orderRepository.distributorOrderRepository.Food2DoorProfile;
import com.kodilla.good.patterns.food2door.products.Product;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class DailyDistributorOrder {

    private DistributorOrderRepository distributorOrderRepository;
    private HashMap<Distributor,Map<Product,Integer>> dailyDistributorOrders = new HashMap<>();

    public DailyDistributorOrder(DistributorOrderRepository distributorOrderRepository) {
        this.distributorOrderRepository = distributorOrderRepository;
    }

    void addOrder(Distributor distributor, Map<Product, Integer> productList) {
        if (dailyDistributorOrders.containsKey(distributor)) {
            productList.forEach((k,v) -> dailyDistributorOrders.get(distributor).merge(k,v,(v1,v2)->v1+v2));
        } else  {
            dailyDistributorOrders.put(distributor,productList);
        }
    }

    void processDailyOrder() {
        for(Map.Entry<Distributor, Map<Product,Integer>> entry : dailyDistributorOrders.entrySet()) {
           entry.getKey().process((HashMap<Product, Integer>) entry.getValue());
        }
        distributorOrderRepository.createOrder(new Food2DoorProfile(), LocalDateTime.now(),dailyDistributorOrders);
    }

}


