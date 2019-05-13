package com.kodilla.good.patterns.flyLikeAStar.flySearchEngine;


import com.kodilla.good.patterns.flyLikeAStar.cities.City;
import com.kodilla.good.patterns.flyLikeAStar.flyService.FlightBase;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class FlightSearchEngine {

    private FlightBase flightBase;

    public FlightSearchEngine( FlightBase flightBase) {
        this.flightBase = flightBase;
    }

    ArrayList<City> getCityByString(String city) {

        ArrayList<City> citiesList = (ArrayList<City>) flightBase.getCitiesList().stream()
                .filter(e -> e.getCityName().equals(city))
                .collect(Collectors.toList());
        if (citiesList.size() < 1) {
            System.out.print("FlyLikeAStar don't fly to " + city);
        }
        return citiesList;
    }

    FlightBase getFlightBase() {
        return flightBase;
    }
}
