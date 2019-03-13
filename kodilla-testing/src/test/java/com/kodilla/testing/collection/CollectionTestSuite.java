package com.kodilla.testing.collection;
import com.kodilla.testing.user.SimpleUser;
import org.junit.*;
import com.kodilla.testing.collection.OddNumbersExterminator;

import java.util.ArrayList;

public class CollectionTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        // Given
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> oddArrayList = new ArrayList<>();
        ArrayList<Integer> result;
        OddNumbersExterminator listOfnumber = new OddNumbersExterminator();
        //When
        result = listOfnumber.exterminate(arrayList);
        System.out.println("Testing "+ result);
        // Then
        Assert.assertEquals(oddArrayList, result);
    }
    @Test
    public void testOddNumbersExterminatorNormalList() {
        // Given
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> oddArrayList = new ArrayList<>();
        ArrayList<Integer> result;
        OddNumbersExterminator listOfnumber = new OddNumbersExterminator();
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
        result = listOfnumber.exterminate(arrayList);
        System.out.println("Testing "+ result);
        // Then
        Assert.assertEquals(oddArrayList, result);
    }

}