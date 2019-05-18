package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    String taskName;
    String whatToBuy;
    double quantity;
    boolean isExecuted = false;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String executeTask() {
        isExecuted = true;
        return "Bought " + whatToBuy + " " +quantity + " pcs";
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public Boolean isTaskExecuted() {
        return isExecuted;
    }
}
