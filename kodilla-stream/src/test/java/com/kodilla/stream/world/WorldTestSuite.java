package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        World world = new World("Earth");
        Continent continent1 = new Continent("Europe");
        Continent continent2 = new Continent("Africa");
        BigDecimal bigDecimal1 = new BigDecimal("2312333333333333333");
        BigDecimal bigDecimal2 = new BigDecimal("1312312312312312312");
        BigDecimal bigDecimal3 = new BigDecimal("131231231231231231");
        BigDecimal bigDecimal4 = new BigDecimal("1112312312312312312");
        BigDecimal bigDecimal5 = new BigDecimal("1142312312312312312");
        Country country1 = new Country("Poland", bigDecimal1);
        Country country2 = new Country("Czech", bigDecimal2);
        Country country3 = new Country("Uganda", bigDecimal3);
        Country country4 = new Country("Zambia", bigDecimal4);
        Country country5 = new Country("Egypt", bigDecimal5);

        //When
        world.getContinents().add(continent1);
        world.getContinents().add(continent2);
        continent1.getCountries().add(country1);
        continent1.getCountries().add(country2);
        continent2.getCountries().add(country3);
        continent2.getCountries().add(country4);
        continent2.getCountries().add(country5);
        BigDecimal results = world.getPeopleQuantity();
        BigDecimal expected = new BigDecimal("6010501501501501500");


        //Then
        Assert.assertEquals(expected, results);
    }
}