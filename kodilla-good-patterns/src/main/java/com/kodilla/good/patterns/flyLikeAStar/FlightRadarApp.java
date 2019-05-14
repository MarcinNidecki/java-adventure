package com.kodilla.good.patterns.flyLikeAStar;

import com.kodilla.good.patterns.flyLikeAStar.flyService.FlightSearchEngine;
import com.kodilla.good.patterns.flyLikeAStar.flyService.FlightBase;
import com.kodilla.good.patterns.flyLikeAStar.flyService.FlightDataRetrieve;

public class FlightRadarApp {

    public static void main(String[] args) {

        FlightBase flightBase = new FlightBase();
        FlightDataRetrieve flightDataRetrieve = new FlightDataRetrieve(flightBase);
        flightDataRetrieve.retrieve();
        FlightSearchEngine flightSearchEngine = new FlightSearchEngine(flightBase);



        System.out.println(flightSearchEngine.findFrom("Warsaw"));
        System.out.println(flightSearchEngine.findTo("Warsaw"));
        System.out.println(flightSearchEngine.findFromCityAtoCityB("Berlin","Katowice"));




    }
}
