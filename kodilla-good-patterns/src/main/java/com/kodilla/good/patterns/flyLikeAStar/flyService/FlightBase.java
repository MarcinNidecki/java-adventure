package com.kodilla.good.patterns.flyLikeAStar.flyService;

import com.kodilla.good.patterns.flyLikeAStar.cities.City;

import java.util.HashSet;

public class FlightBase {


    private HashSet<Flight> flightBase = new HashSet<>();
    private HashSet<City> citiesList = new HashSet<>();


    boolean addFlight(Flight flight) {
        if(flight.getDeparture().getCityOfDeparture().getDestinationList().contains(flight.getArrivals().getCityOfArrivals())){
            flightBase.add(flight);
            return true;
        } else {
            System.out.println("There are no flight from " +flight.getDeparture().getCityOfDeparture().getCityName() + " to " + flight.getArrivals().getCityOfArrivals().getCityName()+ ".");
            return false;
        }
    }

    public HashSet<Flight> getFlightBase() {
        return flightBase;
    }

    public HashSet<City> getCitiesList() {
        return citiesList;
    }



}
