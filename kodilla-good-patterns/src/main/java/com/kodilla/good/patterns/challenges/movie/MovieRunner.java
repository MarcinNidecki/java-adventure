package com.kodilla.good.patterns.challenges.movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieRunner {

    public static void main (String[] args) {

        MovieStore movieStore = new MovieStore();

        String movieList = movieStore.getMovies().values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.joining("!","",""));

        System.out.print(movieList);

    }
}
