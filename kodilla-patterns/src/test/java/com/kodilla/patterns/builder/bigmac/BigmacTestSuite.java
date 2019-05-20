package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigMacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("PLAIN BUN")
                .burgers(2)
                .sauce("STANDARD")
                .ingredients("bacon")
                .ingredients("onion")
                .build();

        //when

        int burgersQuantity = bigmac.getIngredients().size();

        //Then
        Assert.assertEquals(2,burgersQuantity );
        Assert.assertNotNull(bigmac);
    }
}
