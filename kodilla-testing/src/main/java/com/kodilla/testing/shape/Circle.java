package com.kodilla.testing.shape;


public class Circle implements Shape {

    private final int r;

    public Circle(int r) {

        this.r = r;
    }

    public String getShapeName() {

        return "Circle";
    }


    public int getField() {
        return (int) (Math.PI * r * r);

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return r == circle.r;
    }

    @Override
    public int hashCode() {
        return r;
    }

    @Override
    public String toString() {
        return "Circle " +
                "r=" + r +
                ", ";
    }
}
