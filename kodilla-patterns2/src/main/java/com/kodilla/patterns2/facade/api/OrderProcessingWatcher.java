package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Aspect
@Component
public class OrderProcessingWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.kodilla.patterns2.facade.api.OrderProcessingWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processorOrder(..))" +
            "&& args(order,userId) && target(object)")
    public void logEvent(OrderDto order, Long userId, Object object) {
        LOGGER.info("class: " + object.getClass().getName() + ", Order id: " + order.getOrderId() + ", userId: " + userId);
    }
    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processorOrder(..)) && target(object) && args(order,userId)")
    public void logEvent2(OrderDto order,Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + " Items Id's: " + order.getItems().stream().map(n -> n.getProductId().toString()).collect(Collectors.joining(" ,"))+ "  userId: " + userId);
    }
}

