package com.kodilla.good.patterns.flyLikeAStar.flyService;

import com.kodilla.good.patterns.flyLikeAStar.cities.*;

import java.time.LocalDateTime;

public class FlightDataRetrieve {

    private FlightBase flightBase;

    public  FlightDataRetrieve (FlightBase flightBase) {
        this.flightBase = flightBase;

    }
    public void retrieve() {

        Berlin berlin = new Berlin();
        Katowice katowice = new Katowice();
        Poznan poznan = new Poznan();
        Warsaw warsaw = new Warsaw();
        NewYork newYork = new NewYork();

        flightBase.getCitiesList().add(berlin);
        flightBase.getCitiesList().add(katowice);
        flightBase.getCitiesList().add(poznan);
        flightBase.getCitiesList().add(newYork);
        flightBase.getCitiesList().add(warsaw);

        berlin.addDestination(warsaw);
        berlin.addDestination(poznan);

        warsaw.addDestination(berlin);
        warsaw.addDestination(poznan);
        warsaw.addDestination(katowice);

        newYork.addDestination(warsaw);
        newYork.addDestination(berlin);

        poznan.addDestination(katowice);
        poznan.addDestination(warsaw);

        katowice.addDestination(poznan);

        Flight flightTW20 = new Flight(new Departure(warsaw, LocalDateTime.now().plusDays(2).plusHours(5)),new Arrivals(poznan,LocalDateTime.now().plusDays(2).plusHours(2)),"TW20");
        Flight flightTK920 = new Flight(new Departure(warsaw, LocalDateTime.now().plusDays(2)),new Arrivals(katowice,LocalDateTime.now().plusDays(2).plusHours(2)),"TW320");
        Flight flightTW320 = new Flight(new Departure(warsaw, LocalDateTime.now().plusDays(2)),new Arrivals(berlin,LocalDateTime.now().plusDays(2).plusHours(2)),"TW320");
        Flight flightTW120 = new Flight(new Departure(newYork,LocalDateTime.now().plusDays(2).minusHours(2)),new Arrivals(warsaw,LocalDateTime.now().plusDays(2).plusHours(6)),"TW120");
        Flight flightRW420 = new Flight(new Departure(katowice,LocalDateTime.now().plusDays(3).minusHours(4)),new Arrivals(poznan,LocalDateTime.now().plusDays(3).minusHours(1).minusMinutes(30)),"TW120");
        Flight flightCV111 = new Flight(new Departure(berlin,LocalDateTime.now().plusDays(4).minusHours(4)),new Arrivals(poznan,LocalDateTime.now().plusDays(3).minusHours(1).minusMinutes(15)),"CV111");
        Flight flightXV511 = new Flight(new Departure(berlin,LocalDateTime.now().plusDays(4).minusHours(4)),new Arrivals(warsaw,LocalDateTime.now().plusDays(3).minusHours(1).minusMinutes(15)),"CV111");
        Flight flightOPS241 = new Flight(new Departure(poznan,LocalDateTime.now().plusDays(4).minusHours(4)),new Arrivals(katowice,LocalDateTime.now().plusDays(4).minusHours(1).minusMinutes(15)),"CV111");

        flightBase.addFlight(flightTW320);
        flightBase.addFlight(flightTW120);
        flightBase.addFlight(flightRW420);
        flightBase.addFlight(flightOPS241);
        flightBase.addFlight(flightTW20);
        flightBase.addFlight(flightCV111);
        flightBase.addFlight(flightTK920);
        flightBase.addFlight(flightXV511);

    }

}
