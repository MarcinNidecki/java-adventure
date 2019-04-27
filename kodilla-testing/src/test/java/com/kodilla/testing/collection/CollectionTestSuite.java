package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        // Given
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> oddArrayList = new ArrayList<>();
        List<Integer> result;
        OddNumbersExterminator listOfNumber = new OddNumbersExterminator();
        //When
        result = listOfNumber.exterminate(arrayList);
        System.out.println("Testing " + result);
        // Then
        Assert.assertEquals(oddArrayList, result);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        // Given
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> oddArrayList = new ArrayList<>();
        List<Integer> result;
        OddNumbersExterminator listOfNumber = new OddNumbersExterminator();
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(7);
        oddArrayList.add(3);
        oddArrayList.add(1);
        oddArrayList.add(3);
        oddArrayList.add(7);
        //When
        result = listOfNumber.exterminate(arrayList);
        System.out.println("Testing " + result);
        // Then
        Assert.assertEquals(oddArrayList, result);
    }

}