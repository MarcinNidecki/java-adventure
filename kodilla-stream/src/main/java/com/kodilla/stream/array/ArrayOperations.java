package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;


public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        // Average of int[]
        IntStream stream =  IntStream.range(0, numbers.length);
        OptionalDouble results = stream.average();
        // print int[]
        IntStream.range(0, numbers.length)
                .forEach(index -> System.out.print( numbers[index]+ " "));

        return results.getAsDouble();



    }

}
