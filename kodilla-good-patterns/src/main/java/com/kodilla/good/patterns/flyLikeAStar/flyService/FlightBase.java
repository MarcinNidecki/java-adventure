package com.kodilla.good.patterns.flyLikeAStar.flyService;

import java.util.HashSet;

public class FlightBase {


    private HashSet<Flight> flightBase = new HashSet<>();
    private HashSet<City> citiesList = new HashSet<>();


    boolean addFlight(Flight flight) {
        if(flight.getDeparture().getCity().getDestinationList().contains(flight.getArrivals().getCity())){
            flightBase.add(flight);
            return true;
        } else {
            System.out.println("There are no flight from " +flight.getDeparture().getCity().getCityName() + " to " + flight.getArrivals().getCity().getCityName()+ ".");
            return false;
        }
    }

    HashSet<Flight> getFlightBase() {
        return flightBase;
    }

    HashSet<City> getCitiesList() {
        return citiesList;
    }



}
