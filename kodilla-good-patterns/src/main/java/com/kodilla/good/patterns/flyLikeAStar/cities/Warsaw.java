package com.kodilla.good.patterns.flyLikeAStar.cities;

import java.util.HashSet;


public class Warsaw implements City {

    private final String CITY_NAME = "Warsaw";
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

        Warsaw warsaw = (Warsaw) o;

        return CITY_NAME != null ? CITY_NAME.equals(warsaw.CITY_NAME) : warsaw.CITY_NAME == null;
    }

    @Override
    public int hashCode() {
        return CITY_NAME != null ? CITY_NAME.hashCode() : 0;
    }
    @Override
    public String toString() {
        return  CITY_NAME;
    }
}
