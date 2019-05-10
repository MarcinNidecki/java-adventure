package com.kodilla.good.patterns.food2door.orderRepository.distributorOrderRepository;

public class Food2DoorProfile implements CompanyProfile {

    private String companyName = "Food2Door";
    private String companyAddress = "Warszawa, Poligonowa 2a.";
    private String discoundCode = "Door2Dor2019";

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getDiscountCode() {
        return discoundCode;
    }


}
