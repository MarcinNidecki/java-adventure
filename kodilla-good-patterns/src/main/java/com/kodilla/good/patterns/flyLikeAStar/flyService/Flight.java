package com.kodilla.good.patterns.flyLikeAStar.flyService;

import java.time.Duration;
import java.time.LocalDateTime;

public class Flight {

    private Arrivals arrivals;
    private Departure departure;
    private String flightNumber;


    Flight(Departure departure, Arrivals arrivals, String flightNumber) {
        this.departure = departure;
        this.arrivals = arrivals;
        this.flightNumber = flightNumber;
    }

    private String flightDuration() {

        LocalDateTime d1= departure.getDepartureTime();
        LocalDateTime a1 = arrivals.getArrivalsTime();
        Duration duration = Duration.between(d1, a1);

        long seconds = Math.abs(duration.getSeconds());
        long hours = seconds / 3600;
        seconds -= (hours * 3600);
        long minutes = seconds / 60;
        seconds -= (minutes * 60);
        return hours + " hours " + minutes + " minutes " + seconds + " seconds";
    }

    public Arrivals getArrivals() {
        return arrivals;
    }

    public Departure getDeparture() {
        return departure;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "" + departure +
                "" + arrivals +
                ", flight duration: " + flightDuration() +
                ", flight number: " + flightNumber +
                '}';
    }
}
