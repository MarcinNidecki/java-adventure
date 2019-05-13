package com.kodilla.good.patterns.flyLikeAStar.cities;

import java.util.HashSet;

public interface City {

    String getCityName();
    HashSet<City> getDestinationList();
    boolean addDestination(City city);


}
