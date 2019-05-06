package com.kodilla.pacmanv2.pacmanBoard.statistic;

import java.util.Comparator;
import java.util.HashMap;


class ValueComparator implements Comparator<String> {

    private HashMap<String, Integer> map = new HashMap<>();

    ValueComparator(HashMap<String, Integer> map) {
        this.map.putAll(map);
    }

    @Override
    public int compare(String s1, String s2) {
        if (map.get(s1) >= map.get(s2)) {
            return -1;
        } else {
            return 1;
        }
    }
}