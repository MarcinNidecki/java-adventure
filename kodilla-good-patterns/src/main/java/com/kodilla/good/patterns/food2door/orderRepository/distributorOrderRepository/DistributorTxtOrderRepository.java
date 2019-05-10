package com.kodilla.good.patterns.food2door.orderRepository.distributorOrderRepository;


import com.kodilla.good.patterns.food2door.distributors.Distributor;
import com.kodilla.good.patterns.food2door.products.Product;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class DistributorTxtOrderRepository implements DistributorOrderRepository {

        public void createOrder(CompanyProfile companyProfile, LocalDateTime orderTime, HashMap<Distributor, Map<Product, Integer>> orderList) {

            System.out.println("\n\nDaily orders was placed in our TXT distributors orders repository: ");
            System.out.println(companyProfile.getCompanyName()+"  placed order with doscound code: " + companyProfile.getDiscountCode() +". Delivery will be send on addres: " +companyProfile.getCompanyAddress());
            System.out.print(orderList);

    }
}
