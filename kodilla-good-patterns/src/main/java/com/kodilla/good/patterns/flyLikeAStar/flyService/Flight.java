package com.kodilla.good.patterns.flyLikeAStar.flyService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {

    private DepartureArrivals arrivals;
    private DepartureArrivals departure;
    private String flightNumber;


    Flight(DepartureArrivals departure, DepartureArrivals arrivals, String flightNumber) {
        this.departure = departure;
        this.arrivals = arrivals;
        this.flightNumber = flightNumber;
    }

    private String flightDuration() {

        LocalDateTime d1= departure.getTime();
        LocalDateTime a1 = arrivals.getTime();
        Duration duration = Duration.between(d1, a1);

        long seconds = Math.abs(duration.getSeconds());
        long hours = seconds / 3600;
        seconds -= (hours * 3600);
        long minutes = seconds / 60;
        seconds -= (minutes * 60);
        return hours + " hours " + minutes + " minutes " + seconds + " seconds";
    }

    DepartureArrivals getArrivals() {
        return arrivals;
    }

    DepartureArrivals getDeparture() {
        return departure;
    }

    @Override
    public String toString() {
        return "\n" +departure +
                 arrivals +
                ", flight duration: " + flightDuration() +
                ", flight number: " + flightNumber +
                "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!Objects.equals(arrivals, flight.arrivals)) return false;
        if (!Objects.equals(departure, flight.departure)) return false;
        return Objects.equals(flightNumber, flight.flightNumber);
    }

    @Override
    public int hashCode() {
        int result = arrivals != null ? arrivals.hashCode() : 0;
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        result = 31 * result + (flightNumber != null ? flightNumber.hashCode() : 0);
        return result;
    }
}
