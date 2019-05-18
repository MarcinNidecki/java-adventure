package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING_TASK);
        System.out.println(drivingTask.isTaskExecuted());
        String executedTask = drivingTask.executeTask();

        //Then
        Assert.assertEquals("taken  to Warsaw City Center by taxi",executedTask);
        Assert.assertEquals(true, drivingTask.isTaskExecuted());
    }
    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask(TaskFactory.PAINTING_TASK);
        System.out.println(paintingTask.isTaskExecuted());
        String executedTask = paintingTask.executeTask();

        //Then
        Assert.assertEquals("wall painted on blue",executedTask);
        Assert.assertEquals(true, paintingTask.isTaskExecuted());
    }
    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING_TASK);
        System.out.println(shoppingTask.isTaskExecuted());
        String executedTask = shoppingTask.executeTask();

        //Then
        Assert.assertEquals("Bought tomato 2.0 pcs",executedTask);
        Assert.assertEquals(true, shoppingTask.isTaskExecuted());
    }
}
