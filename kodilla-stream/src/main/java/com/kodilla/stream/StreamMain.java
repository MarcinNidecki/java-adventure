package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.decorate("VERY IMPORTANT MESSAGE", textToDecorate -> textToDecorate.toLowerCase());
        poemBeautifier.decorate("VERY IMPORTANT MESSAGE", textToDecorate -> "START  " + textToDecorate.toLowerCase()+ " STOP");
        poemBeautifier.decorate("VERY IMPORTANT MESSAGE", textToDecorate -> "************************************************* \n"+
                textToDecorate+
                "\n*************************************************");

        PoemDecorator poemDecorator = (unSafeString) -> {
            int stringLength = unSafeString.length();
            String[] actualValue = unSafeString.split("", stringLength);
            for (int i = 0; i < stringLength; i += 2)
                actualValue[i] = "*";
            String results = String.join("", actualValue);
            return results;

        };
        poemBeautifier.decorate("How to protected your string ",poemDecorator);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}