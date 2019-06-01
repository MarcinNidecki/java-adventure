package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    InvoiceDao itemDao;
    @Autowired
    ProductDao productDao;

    @Test
   public void testInvoiceDaoSave() {

        //Given
        Product apple = new Product("Apple");
        Product bannana = new Product("Banana");
        Product orange = new Product("Orange");

        Invoice invoice = new Invoice("FV/03/2000");

        Item itemNr1 = new Item(apple,new BigDecimal(200),2,new BigDecimal(400));
        itemNr1.setInvoice(invoice);
        Item itemNr2 = new Item(bannana,new BigDecimal(100),2,new BigDecimal(200));
        itemNr2.setInvoice(invoice);
        Item itemNr3 = new Item(orange,new BigDecimal(50),1,new BigDecimal(50));
        itemNr3 .setInvoice(invoice);



        invoice.getItems().add(itemNr1);
        invoice.getItems().add(itemNr2);
        invoice.getItems().add(itemNr3);

        //When
        productDao.save(apple);
        productDao.save(bannana);
        productDao.save(orange);

        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        int appleId = apple.getId();
        int bannanaId = bannana.getId();
        int orangeId = orange.getId();

        //Then
        Assert.assertNotEquals(0, invoiceId);

        //Clean up
        invoiceDao.deleteById(invoiceId);
        productDao.deleteById(orangeId);
        productDao.deleteById(bannanaId );
        productDao.deleteById(appleId);
    }
}
