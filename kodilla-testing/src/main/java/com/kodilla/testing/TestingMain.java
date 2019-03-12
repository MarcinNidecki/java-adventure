package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();
        int addvalue = calculator.add(4,5);

        if (addvalue == (4+5)) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        int subtractvalue = calculator.subtract(4,5);

        if (subtractvalue == (4-5)) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

    }
}