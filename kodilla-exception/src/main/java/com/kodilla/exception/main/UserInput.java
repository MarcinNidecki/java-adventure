package com.kodilla.exception.main;

public class UserInput {

    public static class TextInput {
        String results = "";

        void add(char c) {
            results = results +c;
        }

         String getValue() {
            return results;
        }
    }

    public static class NumericInput extends TextInput{
        @Override
        void add(char c) {
            if(Character.isDigit(c)) {
                results = results +c;
            }

        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
