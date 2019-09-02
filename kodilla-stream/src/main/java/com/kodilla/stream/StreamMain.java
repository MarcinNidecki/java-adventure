package com.kodilla.stream;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Map<String,Integer> m = new HashMap<>();
        m.put("Test",1);
        m.put("Test",1);
        System.out.print(m.get("Test"));

    }
    public List<Integer> exterminate(List<Integer> numbers) {
        return numbers.stream()
                .filter(i -> i%2 == 0)
                .collect(Collectors.toList());
    }
}