package com.kodilla.good.patterns.food2door.products;

import com.kodilla.good.patterns.food2door.distributors.Distributor;
import com.kodilla.good.patterns.food2door.distributors.GlutenFreeShop;

import java.util.Objects;

public class Milk implements Product {

    private String productName = "Milk";
    private Distributor distributorName = new GlutenFreeShop();
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
        return distributorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Milk milk = (Milk) o;

        if (isFridgeNeeded != milk.isFridgeNeeded) return false;
        if (!Objects.equals(productName, milk.productName)) return false;
        return Objects.equals(distributorName, milk.distributorName);
    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + (distributorName != null ? distributorName.hashCode() : 0);
        result = 31 * result + (isFridgeNeeded ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return productName;
    }
}
