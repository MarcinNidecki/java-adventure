package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.informationService.InformationService;
import com.kodilla.good.patterns.challenges.orderRepository.OrderRepository;
import com.kodilla.good.patterns.challenges.orderService.OrderRequest;
import com.kodilla.good.patterns.challenges.orderService.ProductOrderService.ProductOrderService;

 class OrderProcessor {

    private InformationService informationService;
    private ProductOrderService productOrderService;
    private OrderRepository orderRepository;

     OrderProcessor(InformationService informationService, ProductOrderService productOrderService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.productOrderService = productOrderService;
        this.orderRepository = orderRepository;
    }

    OrderDto process (final OrderRequest orderRequest) {
        boolean isOrdered = productOrderService.order(orderRequest.getUser(), orderRequest.getQuantity(), orderRequest.getOrderTime(),orderRequest.getOrderList());

        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getQuantity(), orderRequest.getOrderTime(),orderRequest.getOrderList());
            return new OrderDto(orderRequest.getUser(),true);
        } else {
            return new OrderDto(orderRequest.getUser(),false);
        }
  }
}
