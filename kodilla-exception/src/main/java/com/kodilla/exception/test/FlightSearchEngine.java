package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {

    public void findFilght(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airPorts = new HashMap<>();
        airPorts.put("Krakow", true);
        airPorts.put("Katowice", true);
        airPorts.put("Warszawa", true);
        airPorts.put("Radom", true);

        if (airPorts.containsKey(flight.getArrivalAirport()) && airPorts.containsKey(flight.getDepartureAirport())) {
            System.out.println("The fligh form " + flight.getArrivalAirport() + " to " + flight.getDepartureAirport() +
                    " was found.");
        } else {
            throw new RouteNotFoundException("Flight was not found");
        }
    }
}
