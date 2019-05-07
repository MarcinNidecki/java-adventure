package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.*;

public final class World {
    private final String worldName;
    private final Set<Continent> continents = new HashSet<>();


    public World(final String worldName) {
        this.worldName = worldName;
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(country -> country.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (BigDecimal sum, BigDecimal current) -> sum = sum.add(current));


    }

    public String getWorldName() {
        return worldName;
    }

    public Set<Continent> getContinents() {
        return continents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        World world = (World) o;

        if (!worldName.equals(world.worldName)) return false;
        return continents != null ? continents.equals(world.continents) : world.continents == null;
    }

    @Override
    public int hashCode() {
        return worldName.hashCode();
    }

    @Override
    public String toString() {
        return "World{" +
                "worldName='" + worldName + '\'' +
                '}';
    }

}
