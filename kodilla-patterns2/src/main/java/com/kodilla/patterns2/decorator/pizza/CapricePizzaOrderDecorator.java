package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class CapricePizzaOrderDecorator extends  AbstractPizzaOrderDecorator{
    public CapricePizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return  super.getCost().add(new BigDecimal(2));
    }

    @Override
    public  String getDescription() {
        return  super.getDescription() + " ham, capsicum, mushroom and anchovies";
    }
}
