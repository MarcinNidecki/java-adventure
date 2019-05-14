package com.kodilla.good.patterns.flyLikeAStar.flyService;

import java.time.LocalDateTime;

public class FlightDataRetrieve {

    private FlightBase flightBase;

    public  FlightDataRetrieve (FlightBase flightBase) {
        this.flightBase = flightBase;

    }
    public void retrieve() {

        City berlin = new City("Berlin");
        City katowice = new City("Katowice");
        City poznan = new City("Poznan");
        City warsaw = new City("Warsaw");
        City newYork = new City("New York");

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

        Flight flightTW20 = new Flight(new DepartureArrivals(warsaw, LocalDateTime.now().plusDays(2).plusHours(5)),new DepartureArrivals(poznan,LocalDateTime.now().plusDays(2).plusHours(7)),"TW20");
        Flight flightTK920 = new Flight(new DepartureArrivals(warsaw, LocalDateTime.now().plusDays(2)),new DepartureArrivals(katowice,LocalDateTime.now().plusDays(2).plusHours(2)),"TW320");
        Flight flightTW320 = new Flight(new DepartureArrivals(warsaw, LocalDateTime.now().plusDays(2)),new DepartureArrivals(berlin,LocalDateTime.now().plusDays(2).plusHours(2)),"TW320");
        Flight flightTW120 = new Flight(new DepartureArrivals(newYork,LocalDateTime.now().plusDays(2).minusHours(2)),new DepartureArrivals(warsaw,LocalDateTime.now().plusDays(2).plusHours(6)),"TW120");
        Flight flightRW420 = new Flight(new DepartureArrivals(katowice,LocalDateTime.now().plusDays(3).minusHours(4)),new DepartureArrivals(poznan,LocalDateTime.now().plusDays(3).minusHours(1).minusMinutes(30)),"TW120");
        Flight flightCV111 = new Flight(new DepartureArrivals(berlin,LocalDateTime.now().plusDays(4).minusHours(4)),new DepartureArrivals(poznan,LocalDateTime.now().plusDays(3).minusHours(1).minusMinutes(15)),"CV111");
        Flight flightXV511 = new Flight(new DepartureArrivals(berlin,LocalDateTime.now().plusDays(4).minusHours(4)),new DepartureArrivals(warsaw,LocalDateTime.now().plusDays(3).minusHours(1).minusMinutes(15)),"CV111");
        Flight flightOPS241 = new Flight(new DepartureArrivals(poznan,LocalDateTime.now().plusDays(4).minusHours(4)),new DepartureArrivals(katowice,LocalDateTime.now().plusDays(4).minusHours(1).minusMinutes(15)),"CV111");

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
