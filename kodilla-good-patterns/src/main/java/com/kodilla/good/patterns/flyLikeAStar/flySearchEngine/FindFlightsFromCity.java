package com.kodilla.good.patterns.flyLikeAStar.flySearchEngine;

import com.kodilla.good.patterns.flyLikeAStar.cities.City;
import com.kodilla.good.patterns.flyLikeAStar.flyService.Flight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindFlightsFromCity implements FindMethod1input {

    private final FlightSearchEngine flightSearchEngine;

    public FindFlightsFromCity(FlightSearchEngine flightSearchEngine) {
        this.flightSearchEngine = flightSearchEngine;
    }

    public  List<Flight> find (String city) {

        List<Flight> foundedFlights = new ArrayList<>();

        if (flightSearchEngine.getCityByString(city).size() >= 1) {
            HashSet<City> destinationCityList = flightSearchEngine.getCityByString(city).get(0).getDestinationList();
            System.out.println("From " + flightSearchEngine.getCityByString(city).get(0).getCityName() + " you can fly to : " + destinationCityList);
            System.out.println("Searching for available flights from " + city + "... ");

            flightSearchEngine.getFlightBase().getFlightBase().stream()
                    .filter(e -> e.getDeparture().getCityOfDeparture().equals(flightSearchEngine.getCityByString(city).get(0)))
                    .forEach(foundedFlights::add);
            foundedFlights.forEach(System.out::println);

        } else {
            System.out.print("FlyLikeAStar don't fly to " + city);
        }
        return foundedFlights;
    }
}