package com.kodilla.exception.test;

public class FirstChallenge {

    private double sum;

    public double divide(double a, double b) throws ArithmeticException {

        try {
            if(b == 0){
                throw new ArithmeticException();
            }
        }catch (ArithmeticException e) {

            System.out.println("Divide by zero error " + e);

        } finally {

            System.out.print("" +a + " / " + b + " = " );

        }   return a/b;
    }


    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) throws ArithmeticException{

        FirstChallenge firstChallenge = new FirstChallenge();

        double result = firstChallenge.divide(3, 0);

        System.out.println(result);

    }
}