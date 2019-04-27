package com.kodilla.exception.test;

public class FlightRunner {

    public static void main(String[] args) {

        Flight flight = new Flight("Krakow", "Warszawa");
        FlightSearchEngine flightSearchEngine = new FlightSearchEngine();

        try {
            flightSearchEngine.findFilght(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("no flights");
        }

    }
}
