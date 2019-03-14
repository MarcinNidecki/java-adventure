package com.kodilla.testing.shape;
import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> shapesList = new ArrayList<>();


    public void addFigure(Shape shape) {
        shapesList.add(shape);
    }

    public boolean  removeFigure(Shape shape) {
        boolean result = false;
        if (shapesList.contains(shape)) {
            shapesList.remove(shape);
            return result = true;
        } else
        return result;
    }

    public Shape getFigure(int n) {
        return shapesList.get(n);
    }

    public String ShowFigures() {
        String results = "";
        for(Shape theShape: shapesList){
            results += theShape.toString();
        }
        return results;
    }

    public int getShapesQuantity(){
        return shapesList.size();
    }
}
