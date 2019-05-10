package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.informationService.MailService;
import com.kodilla.good.patterns.challenges.orderRepository.TxtOrderRepository;
import com.kodilla.good.patterns.challenges.orderService.productOrderService.FoodOrderService;
import com.kodilla.good.patterns.challenges.orderService.OrderRequest;
import com.kodilla.good.patterns.challenges.orderService.OrderRequestRetrieve;

public class Application {

    public static void main(String[] args) {

        OrderRequestRetrieve orderRequestRetrieve = new OrderRequestRetrieve();
        OrderRequest orderRequest = orderRequestRetrieve.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new FoodOrderService(), new TxtOrderRepository());
        orderProcessor.process(orderRequest);

    }



}
