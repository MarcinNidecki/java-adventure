package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void  testLog() {

        //Given
        Logger.getInstance().log("Login successful.");
        //When
        String result = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("Login successful.", result);
    }
}
