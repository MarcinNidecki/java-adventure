package com.kodilla.stream.array;

import java.util.stream.IntStream;


public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        // print int[]
        IntStream.range(0, numbers.length)
                .forEach(index -> System.out.print( numbers[index]+ " "));
        // return Average of int[]
        return IntStream.of(numbers).average().getAsDouble();



    }

}
