package com.kodilla.stream.invoice.simple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SimpleInvoiceTestSuite {


    @Test
    public void testGetValue() {
        // Given
        SimpleProduct simpleProduct = new SimpleProduct("Product 1", 12.00);
        SimpleProduct simpleProduct2 = new SimpleProduct("Product 2", 2.00);

        SimpleItem simpleItem = new SimpleItem(simpleProduct,7.00);
        SimpleItem simpleItem2 = new SimpleItem(simpleProduct2,5.00);
        SimpleItem simpleItem3= new SimpleItem(simpleProduct2,2.00);
        SimpleItem simpleItem4 = new SimpleItem(simpleProduct2,2.00);
        SimpleItem simpleItem5 = new SimpleItem(simpleProduct2,2.00);

        List<SimpleItem> simpleItemList = new ArrayList<>();
        simpleItemList.add(simpleItem2);
        simpleItemList.add(simpleItem3);
        simpleItemList.add(simpleItem);
        simpleItemList.add(simpleItem4);
        simpleItemList.add(simpleItem5);
        double sum = 0.00;
        // when
        for (SimpleItem item: simpleItemList) {
            sum += item.getValue();
        }
        //then
        assertEquals(106.00, sum);
    }
}
