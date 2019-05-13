package com.kodilla.good.patterns.flyLikeAStar.cities;

import java.util.HashSet;


public class NewYork implements City {

    private final String CITY_NAME = "New York";
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

    public String getCityName() {
        return CITY_NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewYork newYork = (NewYork) o;

        if (!CITY_NAME.equals(newYork.CITY_NAME)) return false;
        return destinationList != null ? destinationList.equals(newYork.destinationList) : newYork.destinationList == null;
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
