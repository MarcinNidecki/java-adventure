package com.kodilla.stream.array;

import java.util.stream.IntStream;


public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        // Average of int[]

        double stream =  IntStream.range(0, numbers.length)
                .reduce(0, (sum, current) -> sum = sum + numbers[current]);
        // print int[]
        IntStream.range(0, numbers.length)
                .forEach(index -> System.out.print( numbers[index]+ " "));

        return stream/numbers.length;



    }

}
