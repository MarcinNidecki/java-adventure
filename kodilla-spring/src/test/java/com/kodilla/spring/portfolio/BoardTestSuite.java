package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testRead() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When & Then
        board.getDoneList().getTasks().add("Test 1");
        board.getInProgressList().getTasks().add("Test 2");
        board.getToDoList().getTasks().add("Test 3");

        String result1 = board.getDoneList().getTasks().get(0);
        String result2 = board.getInProgressList().getTasks().get(0);
        String result3 = board.getToDoList().getTasks().get(0);
        //Then
        Assert.assertEquals("Test 1", result1);
        Assert.assertEquals("Test 2", result2);
        Assert.assertEquals("Test 3", result3);

    }

}