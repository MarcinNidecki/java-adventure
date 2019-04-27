package com.kodilla.exception.test;

public class FirstChallenge {

    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        double result = 0;
        try {
            result = firstChallenge.divide(3, 0);
            System.out.println("Results: =" + result);
        } catch (ArithmeticException e) {
            System.out.println("Divide by zero error " + e);
        } finally {
            System.out.println("Done!");
        }


    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }
}