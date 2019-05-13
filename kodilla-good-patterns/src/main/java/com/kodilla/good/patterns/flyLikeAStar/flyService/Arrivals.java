package com.kodilla.good.patterns.flyLikeAStar.flyService;

import com.kodilla.good.patterns.flyLikeAStar.cities.City;

import java.time.LocalDateTime;

public class Arrivals {

    private City cityOfArrivals;
    private LocalDateTime arrivalsTime;

    Arrivals(City cityOfArrivals, LocalDateTime arrivalsTime) {
        this.cityOfArrivals = cityOfArrivals;
        this.arrivalsTime = arrivalsTime;
    }

    public City getCityOfArrivals() {
        return cityOfArrivals;
    }

    LocalDateTime getArrivalsTime() {
        return arrivalsTime;
    }

    @Override
    public String toString() {
        return "to: " + cityOfArrivals +
                ", arrival time: " + arrivalsTime.getHour() +":"+ arrivalsTime.getMinute();
    }
}
