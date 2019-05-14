package com.kodilla.good.patterns.flyLikeAStar.flyService;

import java.util.HashSet;


public class City  {

    private String cityName;
    private HashSet<City> destinationList  = new HashSet<>();

    City(String cityName) {
        this.cityName = cityName;
    }

    HashSet<City> getDestinationList() {
        return destinationList;
    }

    boolean addDestination(City city) {
        destinationList.add(city);
        return false;
    }

    String getCityName() {
        return cityName;
    }

    @Override
    public int hashCode() {
        return cityName.hashCode();
    }

    @Override
    public String toString() {
        return  cityName;
    }
}
