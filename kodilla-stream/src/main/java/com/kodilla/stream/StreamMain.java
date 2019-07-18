package com.kodilla.stream;


import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {



    }
    public List<Integer> exterminate(List<Integer> numbers) {
        return numbers.stream()
                .filter(i -> i%2 == 0)
                .collect(Collectors.toList());
    }
}