package com.kodilla.good.patterns.food2door.products;

import com.kodilla.good.patterns.food2door.distributors.Distributor;

public interface Product {

    String getProductName();
    Distributor getDistributors();
    boolean isFridgeNeeded();
    boolean equals(Object o);
    int hashCode();

}
