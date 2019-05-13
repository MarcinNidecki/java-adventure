package com.kodilla.good.patterns.flyLikeAStar.flySearchEngine;

import com.kodilla.good.patterns.flyLikeAStar.cities.City;
import com.kodilla.good.patterns.flyLikeAStar.flyService.Flight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindFlightFromCityToCity implements FindMethod2Input {
    private final FlightSearchEngine flightSearchEngine;

    public FindFlightFromCityToCity(FlightSearchEngine flightSearchEngine) {
        this.flightSearchEngine = flightSearchEngine;
    }



    public List<Flight> find (String departureCityName, String arrivalsCityName) {
        List<Flight> availableFlights = new ArrayList<>();

        if (flightSearchEngine.getCityByString(departureCityName).size() > 0 && flightSearchEngine.getCityByString(arrivalsCityName).size() > 0) {
            City departureCity = flightSearchEngine.getCityByString(departureCityName).get(0);
            City arrivalsCity = flightSearchEngine.getCityByString(arrivalsCityName).get(0);
            List<Flight> foundedFlights = new ArrayList<>();

            flightSearchEngine.getFlightBase().getFlightBase().stream()
                    .filter(e -> e.getArrivals().getCityOfArrivals().equals(departureCity))
                    .filter(e -> e.getDeparture().getCityOfDeparture().equals(arrivalsCity))
                    .forEach(foundedFlights::add);

            System.out.println(departureCity + " - " + arrivalsCity + " - checking flight possibilities.");

            if (foundedFlights.size() >= 1) {
                System.out.println("We have " + foundedFlights.size() + " direct(s) fly:");
                System.out.println(foundedFlights);
            }

            HashSet<City> connectingCities = new HashSet<>();
            departureCity.getDestinationList().stream()
                    .filter(e -> e.getDestinationList().contains(arrivalsCity))
                    .forEach(connectingCities::add);

            System.out.println("From " + departureCity + " to " + arrivalsCity + " you can fly via:" + connectingCities);
            System.out.println("Searching ...");

            connectingCities.forEach(connectingCity -> flightSearchEngine.getFlightBase().getFlightBase().stream()
                    .filter(flight -> flight.getDeparture().getCityOfDeparture().equals(departureCity))
                    .filter(flight -> flight.getArrivals().getCityOfArrivals().equals(connectingCity))
                    .forEach(firstFly -> flightSearchEngine.getFlightBase().getFlightBase().stream()
                            .filter(secondFlight -> secondFlight.getDeparture().getCityOfDeparture().equals(firstFly.getArrivals().getCityOfArrivals()))
                            .filter(secondFlight -> secondFlight.getArrivals().getCityOfArrivals().equals(arrivalsCity))
                            .forEach(secondFlight -> {
                                availableFlights.add(firstFly);
                                availableFlights.add(secondFlight);
                            })));

            int option = 1;
            for (int i = 0; i < availableFlights.size(); i++) {
                if (i % 2 == 0) {
                    System.out.println("Option: " + option);
                    option++;
                }
                System.out.println(availableFlights.get(i));
            }
        }
        return availableFlights;
    }

}