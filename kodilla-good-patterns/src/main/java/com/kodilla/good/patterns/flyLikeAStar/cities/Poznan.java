package com.kodilla.good.patterns.flyLikeAStar.cities;

import java.util.HashSet;


public class Poznan implements City {

    private final String CITY_NAME = "Poznań";
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

        Poznan poznan = (Poznan) o;

        return CITY_NAME != null ? CITY_NAME.equals(poznan.CITY_NAME) : poznan.CITY_NAME == null;
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
