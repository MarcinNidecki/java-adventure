package com.kodilla.good.patterns.food2door.distributors;

import com.kodilla.good.patterns.food2door.products.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HealthyShop implements Distributor {

    private String distributorName = "HealthyShop";

    @Override
    public void process(HashMap<Product, Integer> productList) {
        System.out.println("Daily order  from supplier  " + distributorName +": ");
        for(Map.Entry<Product, Integer> entry : productList.entrySet()) {

            System.out.println(entry.getKey().getProductName() + " in quantity: " + entry.getValue());
        }
    }

    @Override
    public String getDistributorName() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HealthyShop that = (HealthyShop) o;

        return Objects.equals(distributorName, that.distributorName);
    }

    @Override
    public int hashCode() {
        return distributorName != null ? distributorName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return distributorName;
    }
}
