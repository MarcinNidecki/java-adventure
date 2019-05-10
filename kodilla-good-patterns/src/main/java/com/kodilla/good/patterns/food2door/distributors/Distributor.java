package com.kodilla.good.patterns.food2door.distributors;

import com.kodilla.good.patterns.food2door.products.Product;

import java.util.HashMap;

public interface Distributor {

    void process(HashMap<Product,Integer> productList);
    String getDistributorName();
    boolean equals(Object o);
    int hashCode();
    String toString();
}
