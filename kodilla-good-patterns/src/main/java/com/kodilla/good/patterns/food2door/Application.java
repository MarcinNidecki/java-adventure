package com.kodilla.good.patterns.food2door;


import com.kodilla.good.patterns.food2door.informationService.MailService;
import com.kodilla.good.patterns.food2door.orderRepository.clientOrderRepository.ClientTxtOrderRepository;
import com.kodilla.good.patterns.food2door.orderRepository.distributorOrderRepository.DistributorTxtOrderRepository;
import com.kodilla.good.patterns.food2door.orderService.DailyDistributorOrder;
import com.kodilla.good.patterns.food2door.orderService.OrderProcessor;
import com.kodilla.good.patterns.food2door.orderService.OrderRequest;
import com.kodilla.good.patterns.food2door.orderService.OrderRequestRetrieve;


public class Application {
    public static void main(String[] args) {

        OrderRequestRetrieve orderRequestRetrieve = new OrderRequestRetrieve();
        OrderRequest orderRequest = orderRequestRetrieve.retrieve();
        OrderRequest orderRequest1 = orderRequestRetrieve.retrieve2();

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new ClientTxtOrderRepository(), new DailyDistributorOrder( new DistributorTxtOrderRepository()));
        orderProcessor.process(orderRequest);
        orderProcessor.process(orderRequest1);

        orderProcessor.processDailyOrders();


    }


}
