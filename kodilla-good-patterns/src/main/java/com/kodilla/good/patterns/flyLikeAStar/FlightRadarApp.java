package com.kodilla.good.patterns.flyLikeAStar;

import com.kodilla.good.patterns.flyLikeAStar.flySearchEngine.FindFlightFromCityToCity;
import com.kodilla.good.patterns.flyLikeAStar.flySearchEngine.FindFlightsFromCity;
import com.kodilla.good.patterns.flyLikeAStar.flySearchEngine.FindFlightsToCity;
import com.kodilla.good.patterns.flyLikeAStar.flySearchEngine.FlightSearchEngine;
import com.kodilla.good.patterns.flyLikeAStar.flyService.FlightBase;
import com.kodilla.good.patterns.flyLikeAStar.flyService.FlightDataRetrieve;

public class FlightRadarApp {

    public static void main(String[] args) {

        FlightBase flightBase = new FlightBase();
        FlightDataRetrieve flightDataRetrieve = new FlightDataRetrieve(flightBase);
        flightDataRetrieve.retrieve();

        FlightSearchEngine flightSearchEngine = new FlightSearchEngine(flightBase);
        FindFlightsFromCity findFlightsFromCity = new FindFlightsFromCity(flightSearchEngine);
        FindFlightsToCity findFlightsToCity = new FindFlightsToCity(flightSearchEngine);
        FindFlightFromCityToCity findFlightFromCityToCity = new FindFlightFromCityToCity(flightSearchEngine);

        findFlightsFromCity.find("Warsaw");
        System.out.println("-------------------------------------------------------------\n");
        findFlightsToCity.find("Warsaw");
        System.out.println("-------------------------------------------------------------\n");
        findFlightFromCityToCity.find("Berlin","Katowice");




    }
}
