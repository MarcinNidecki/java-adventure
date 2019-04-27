package com.kodilla.stream.world;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class Continent {


    private final String nameOfContinent;
    private final Set<Country> countries = new HashSet<>();

    public Continent(String nameOfContinent) {
        this.nameOfContinent = nameOfContinent;
    }

    public String getNameOfContinent() {
        return nameOfContinent;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public BigDecimal getPeopleQuantity() {
        return countries.stream()
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (BigDecimal sum, BigDecimal current) -> sum = sum.add(current));


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continent continent = (Continent) o;

        return nameOfContinent.equals(continent.nameOfContinent);
    }

    @Override
    public int hashCode() {
        return nameOfContinent.hashCode();
    }

    @Override
    public String toString() {
        return "Continent{" +
                "nameOfContinent='" + nameOfContinent + '\'' +
                '}';
    }
}
