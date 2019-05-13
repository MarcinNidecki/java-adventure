package com.kodilla.good.patterns.flyLikeAStar.cities;

import java.util.HashSet;


public class Katowice implements City {

    private final String CITY_NAME = "Katowice";
    private HashSet<City> destinationList = new HashSet<>();


    @Override
    public HashSet<City> getDestinationList() {
        return destinationList;
    }

    @Override
    public boolean addDestination(City city) {
        destinationList.add(city);
        return false;
    }

    @Override
    public String getCityName() {
        return CITY_NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Katowice katowice = (Katowice) o;

        return CITY_NAME.equals(katowice.CITY_NAME);
    }

    @Override
    public int hashCode() {
        return CITY_NAME.hashCode();
    }
    @Override
    public String toString() {
        return  CITY_NAME;
    }
}
