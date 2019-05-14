package com.kodilla.good.patterns.flyLikeAStar.flyService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchEngine {

    private FlightBase flightBase;

    public FlightSearchEngine(FlightBase flightBase) {
        this.flightBase = flightBase;
    }

    public List<Flight> findTo (String city) {

        return getFlightBase().getFlightBase().stream()
                    .filter(e -> e.getArrivals().getCity().equals(getCityByString(city).get(0)))
                    .collect(Collectors.toList());
    }

    public List<Flight> findFrom(String city) {
        return getFlightBase().getFlightBase().stream()
                .filter(e -> e.getDeparture().getCity().equals(getCityByString(city).get(0)))
                .collect(Collectors.toList());
    }


    public List<Flight> findFromCityAtoCityB (String departureCityName, String arrivalsCityName) {
        List<Flight> availableFlights = new ArrayList<>();

        City departureCity = getCityByString(departureCityName).get(0);
        City arrivalsCity = getCityByString(arrivalsCityName).get(0);

        getFlightBase().getFlightBase().stream()
                .filter(e -> e.getArrivals().getCity().equals(departureCity))
                .filter(e -> e.getDeparture().getCity().equals(arrivalsCity))
                .forEach(availableFlights::add);

        departureCity.getDestinationList().stream()
                .filter(e -> e.getDestinationList().contains(arrivalsCity))
                .forEach(connectingCity -> getFlightBase().getFlightBase().stream()
                        .filter(flight -> flight.getDeparture().getCity().equals(departureCity))
                        .filter(flight -> flight.getArrivals().getCity().equals(connectingCity))
                        .forEach(firstFly -> getFlightBase().getFlightBase().stream()
                                .filter(secondFlight -> secondFlight.getDeparture().getCity().equals(firstFly.getArrivals().getCity()))
                                .filter(secondFlight -> secondFlight.getArrivals().getCity().equals(arrivalsCity))
                                .forEach(secondFlight -> {
                                    availableFlights.add(firstFly);
                                    availableFlights.add(secondFlight);
                                })));

        return availableFlights;
    }

   private ArrayList<City> getCityByString(String city) {

        ArrayList<City> citiesList = (ArrayList<City>) flightBase.getCitiesList().stream()
                .filter(e -> e.getCityName().equals(city))
                .collect(Collectors.toList());
        if (citiesList.size() < 1) {
            System.out.print("FlyLikeAStar don't fly to " + city);
        }
        return citiesList;
    }

    private FlightBase getFlightBase() {
        return flightBase;
    }

}