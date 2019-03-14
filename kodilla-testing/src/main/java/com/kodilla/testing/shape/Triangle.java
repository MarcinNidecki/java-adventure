package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private int sideA;
    private int H;

    public Triangle(int sideA, int H) {
        this.sideA = sideA;
        this.H = H;

    }

    @Override
    public String getShapeName() {

        return "Triangle";
    }

    @Override
    public int getField() {
        return (sideA*H)/2;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (sideA != triangle.sideA) return false;
        return H == triangle.H;
    }

    @Override
    public int hashCode() {
        int result = sideA;
        result = 31 * result + H;
        return result;
    }

    @Override
    public String toString() {
        return "Triangle " +
                "sideA=" + sideA +
                ", sideH=" + H +
                ", ";
    }
}
