package com.kodilla.testing.shape;

public class Square implements Shape {

    private int a;

    public Square(int a) {
        this.a = a;
    }

    @Override
    public String getShapeName() {

        return "Square";
    }

    @Override
    public int getField() {
        return a * a;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return a == square.a;
    }

    @Override
    public int hashCode() {
        return a;
    }

    @Override
    public String toString() {
        return "Square " +
                "a=" + a +
                ", ";
    }
}
