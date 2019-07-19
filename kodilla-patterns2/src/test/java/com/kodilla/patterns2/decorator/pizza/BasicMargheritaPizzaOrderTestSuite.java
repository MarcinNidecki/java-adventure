package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BasicMargheritaPizzaOrderTestSuite {
    @Test
    public void testHawaiianPizzaWithChickenGarlicSauceGetCost() {
        //Given
        PizzaOrder theOrder = new BasicMargheritaPizzaOrder();
        theOrder = new HawaiianPizzaOrderDecorator(theOrder);
        theOrder = new ChickenPizzaToppingDecorator(theOrder);
        theOrder = new GarlicSauceDecorator(theOrder);
        System.out.println(theOrder.getCost());
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(18),theCost);
    }
    @Test
    public void testHawaiianPizzaWithChickenGarlicSauceGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicMargheritaPizzaOrder();
        theOrder = new HawaiianPizzaOrderDecorator(theOrder);
        theOrder = new ChickenPizzaToppingDecorator(theOrder);
        theOrder = new GarlicSauceDecorator(theOrder);
        System.out.println(theOrder.getDescription());
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Mozzarella, tomato, basil and herbs ham and pineapple + chicken + garlic sauce",description);
    }
}
