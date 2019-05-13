package com.kodilla.good.patterns.flyLikeAStar.flyService;

import com.kodilla.good.patterns.flyLikeAStar.cities.City;

import java.time.LocalDateTime;

public class Departure {

    private City cityOfDeparture;
    private LocalDateTime departureTime;

    Departure(City cityOfDeparture, LocalDateTime departureTime) {
        this.cityOfDeparture = cityOfDeparture;
        this.departureTime = departureTime;
    }

    public City getCityOfDeparture() {
        return cityOfDeparture;
    }

    LocalDateTime getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return "From: " + cityOfDeparture +
                ", departure time: " +  departureTime.getHour() +":"+ departureTime.getMinute() + " ";
    }
}
