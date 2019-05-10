package com.kodilla.good.patterns.food2door.products;

import com.kodilla.good.patterns.food2door.distributors.Distributor;
import com.kodilla.good.patterns.food2door.distributors.HealthyShop;

import java.util.Objects;

public class Orange implements Product {

    private String productName = "Orange";
    private Distributor distributors = new HealthyShop();
    private boolean isFridgeNeeded = true;


    @Override
    public boolean isFridgeNeeded() {
        return isFridgeNeeded;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public Distributor getDistributors() {
        return distributors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orange orange = (Orange) o;

        if (isFridgeNeeded != orange.isFridgeNeeded) return false;
        if (!Objects.equals(productName, orange.productName)) return false;
        return Objects.equals(distributors, orange.distributors);
    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + (distributors != null ? distributors.hashCode() : 0);
        result = 31 * result + (isFridgeNeeded ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return productName;
    }
}
