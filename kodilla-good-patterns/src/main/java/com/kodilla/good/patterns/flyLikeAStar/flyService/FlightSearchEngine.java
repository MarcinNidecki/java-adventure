package com.kodilla.good.patterns.flyLikeAStar.flyService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchEngine {

    private FlightBase flightBase;

    public FlightSearchEngine(FlightBase flightBase) {
        this.flightBase = flightBase;
    }


    public List<Flight> findTo (String city) {
        List<Flight> foundedFlights = new ArrayList<>();
        City cityFromString = getCityByString(city).get(0);

        if (getCityByString(city).size() >=1) {
            HashSet<City> departureCityList = new HashSet<>();
            getFlightBase().getCitiesList().stream()
                    .filter(e-> e.getDestinationList().contains(cityFromString))
                    .forEach(departureCityList::add);

            System.out.println("To " + cityFromString.getCityName() + " you can fly from : " +departureCityList);
            System.out.println("Searching for available flights to "  + city + "... ");

            getFlightBase().getFlightBase().stream()
                    .filter(e -> e.getArrivals().getCity().equals(cityFromString))
                    .forEach(foundedFlights::add);
            foundedFlights.forEach(System.out::println);

        } else {
            System.out.print("FlyLikeAStar don't fly to " + city);

        } return foundedFlights;
    }

    public  List<Flight> findFrom (String city) {

        List<Flight> foundedFlights = new ArrayList<>();

        if (getCityByString(city).size() >= 1) {
            HashSet<City> destinationCityList = getCityByString(city).get(0).getDestinationList();
            System.out.println("From " + getCityByString(city).get(0).getCityName() + " you can fly to : " + destinationCityList);
            System.out.println("Searching for available flights from " + city + "... ");

            getFlightBase().getFlightBase().stream()
                    .filter(e -> e.getDeparture().getCity().equals(getCityByString(city).get(0)))
                    .forEach(foundedFlights::add);
            foundedFlights.forEach(System.out::println);

        } else {
            System.out.print("FlyLikeAStar don't fly to " + city);
        }
        return foundedFlights;
    }

    public List<Flight> findFromCityAtoCityB (String departureCityName, String arrivalsCityName) {
        List<Flight> availableFlights = new ArrayList<>();

        if (getCityByString(departureCityName).size() > 0 && getCityByString(arrivalsCityName).size() > 0) {
            City departureCity = getCityByString(departureCityName).get(0);
            City arrivalsCity = getCityByString(arrivalsCityName).get(0);
            List<Flight> foundedFlights = new ArrayList<>();

            getFlightBase().getFlightBase().stream()
                    .filter(e -> e.getArrivals().getCity().equals(departureCity))
                    .filter(e -> e.getDeparture().getCity().equals(arrivalsCity))
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

            connectingCities.forEach(connectingCity -> getFlightBase().getFlightBase().stream()
                    .filter(flight -> flight.getDeparture().getCity().equals(departureCity))
                    .filter(flight -> flight.getArrivals().getCity().equals(connectingCity))
                    .forEach(firstFly -> getFlightBase().getFlightBase().stream()
                            .filter(secondFlight -> secondFlight.getDeparture().getCity().equals(firstFly.getArrivals().getCity()))
                            .filter(secondFlight -> secondFlight.getArrivals().getCity().equals(arrivalsCity))
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