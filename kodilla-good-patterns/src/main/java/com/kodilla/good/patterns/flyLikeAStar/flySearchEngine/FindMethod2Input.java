package com.kodilla.good.patterns.flyLikeAStar.flySearchEngine;

import com.kodilla.good.patterns.flyLikeAStar.flyService.Flight;

import java.util.List;

public interface FindMethod2Input {

    List<Flight> find(String departureCityName, String arrivalsCityName);
}
