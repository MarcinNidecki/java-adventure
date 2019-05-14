package com.kodilla.good.patterns.flyLikeAStar.flyService;

import java.time.LocalDateTime;

public class DepartureArrivals {

    private City city;
    private LocalDateTime departureOrArrivalsTime;

    DepartureArrivals(City city, LocalDateTime departureOrArrivalsTime) {
        this.city = city;
        this.departureOrArrivalsTime = departureOrArrivalsTime;
    }

    City getCity() {
        return city;
    }

    LocalDateTime getTime() {
        return departureOrArrivalsTime;
    }

    @Override
    public String toString() {
        return " " + city +
                ", time: " + departureOrArrivalsTime.getHour() +":"+ departureOrArrivalsTime.getMinute();
    }
}
