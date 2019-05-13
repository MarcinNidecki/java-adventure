package com.kodilla.good.patterns.flyLikeAStar.flySearchEngine;

import com.kodilla.good.patterns.flyLikeAStar.cities.City;
import com.kodilla.good.patterns.flyLikeAStar.flyService.Flight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindFlightsToCity implements FindMethod1input {

    private final FlightSearchEngine flightSearchEngine;

    public FindFlightsToCity(FlightSearchEngine flightSearchEngine) {
        this.flightSearchEngine = flightSearchEngine;
    }

    public List<Flight> find (String city) {
        List<Flight> foundedFlights = new ArrayList<>();
        City cityFromString = flightSearchEngine.getCityByString(city).get(0);

        if (flightSearchEngine.getCityByString(city).size() >=1) {
            HashSet<City> departureCityList = new HashSet<>();
            flightSearchEngine.getFlightBase().getCitiesList().stream()
                    .filter(e-> e.getDestinationList().contains(cityFromString))
                    .forEach(departureCityList::add);

            System.out.println("To " + cityFromString.getCityName() + " you can fly from : " +departureCityList);
            System.out.println("Searching for available flights to "  + city + "... ");

            flightSearchEngine.getFlightBase().getFlightBase().stream()
                    .filter(e -> e.getArrivals().getCityOfArrivals().equals(cityFromString))
                    .forEach(foundedFlights::add);
            foundedFlights.forEach(System.out::println);

        } else {
            System.out.print("FlyLikeAStar don't fly to " + city);

        } return foundedFlights;
    }
}
