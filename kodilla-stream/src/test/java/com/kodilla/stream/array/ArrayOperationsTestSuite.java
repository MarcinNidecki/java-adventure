package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        int[] array = {2,2,2,2,2,2};

        //When
        double results = ArrayOperations.getAverage(array);
        System.out.print(results);

        //Then
        Assert.assertEquals(2, results,0);
    }

}
