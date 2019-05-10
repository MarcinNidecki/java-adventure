package com.kodilla.good.patterns.food2door.orderService;


import com.kodilla.good.patterns.food2door.distributors.Distributor;
import com.kodilla.good.patterns.food2door.informationService.InformationService;
import com.kodilla.good.patterns.food2door.orderRepository.clientOrderRepository.ClientOrderRepository;
import com.kodilla.good.patterns.food2door.products.Product;

import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderProcessor {

    private InformationService informationService;
    private ClientOrderRepository clientOrderRepository;
    private DailyDistributorOrder dailyDistributorOrder;


    public OrderProcessor(InformationService informationService, ClientOrderRepository clientOrderRepository, DailyDistributorOrder dailyDistributorOrder) {
        this.informationService = informationService;
        this.clientOrderRepository = clientOrderRepository;
        this.dailyDistributorOrder = dailyDistributorOrder;

    }

    public void process (final OrderRequest orderRequest) {

        HashSet<Distributor> distributorsList = new HashSet<>();
        orderRequest.getOrderList().forEach((key, value) -> distributorsList.add(key.getDistributors()));

        System.out.println(orderRequest.getUser().getUserName() + " was ordered: ");
        for (Distributor distributor: distributorsList) {
            Map<Product,Integer> orderList =orderRequest.getOrderList().entrySet().stream()
                    .filter(p -> p.getKey().getDistributors().equals(distributor))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            dailyDistributorOrder.addOrder(distributor,orderList);
            System.out.println(orderList);
        }
        informationService.inform(orderRequest.getUser());
        clientOrderRepository.createOrder(orderRequest.getUser(),orderRequest.getOrderTime(),orderRequest.getOrderList());
    }

    public void processDailyOrders () {
        dailyDistributorOrder.processDailyOrder();

    }

}
