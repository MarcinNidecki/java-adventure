package com.kodilla.patterns.factory.tasks;


public class TaskFactory {

    public static final String DRIVING_TASK = " DRIVING TASK";
    public static final String PAINTING_TASK = " PAINTING TASK";
    public static final String SHOPPING_TASK = " SHOPPING TASK";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case DRIVING_TASK:
                return new DrivingTask("Driving task","Warsaw City Center", "taxi");
            case PAINTING_TASK:
                return new PaintingTask("Painting task","blue", "wall");
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping task","tomato",2);
            default:
                return null;
        }

    }
}
