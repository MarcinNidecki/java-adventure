package com.kodilla.patterns2.decorator.taxiportal;

public class TaxiNetworkOrderDecorator extends AbstractTaxiOrderDecorator {
    public TaxiNetworkOrderDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }
}
