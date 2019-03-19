package com.kodilla.testing.shape;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();

        //When
        collector.addFigure(new Square(30));

        //Then
        Assert.assertEquals(1, collector.getShapesQuantity());

    }
    @Test
    public void testRemoveExistingFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        List<Shape> shapes = new ArrayList<>();
        Shape shape = new Square(30);
        collector.addFigure(shape);

        //When
        boolean result = collector.removeFigure(shape);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapes.size());
    }
    @Test
    public void testRemoveNotExistingFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        List<Shape> shapes = new ArrayList<>();
        Shape shape = new Square(30);

        //When
        boolean result = collector.removeFigure(shape);

        //Then
        Assert.assertFalse(result);
    }
    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        List<Shape> shapes = new ArrayList<>();
        Shape square = new Square(30);
        collector.addFigure(square);

        //When
        Shape retrievedFigure = collector.getFigure(0);

        //Then
        Assert.assertEquals(square, retrievedFigure);
    }
    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(new Circle(3));
        collector.addFigure(new Circle(1));
        collector.addFigure(new Square(3));


        String results = collector.ShowFigures();


        //Then
        Assert.assertEquals("Circle r=3, Circle r=1, Square a=3, ",results );
    }
    @Test
    public void TestGetShapesQuantity() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(new Square(30));

        //When
        int result = collector.getShapesQuantity();

        //Then
        Assert.assertEquals(1, result);

    }
    @Test
    public void TestGetFieldCircle() {
        //Given
        Shape circle = new Circle(4);

        //When
        int result = circle.getField();

        //Then
        Assert.assertEquals(50, result);
    }
    @Test
    public void TestGetFieldSquare() {
        //Given
        Shape square = new Square(4);

        //When
        int result = square.getField();

        //Then
        Assert.assertEquals(16, result);
    }
    @Test
    public void TestGetFieldTriangle() {
        //Given
        Shape triangle = new Triangle(15, 4);

        //When
        int result = triangle.getField();

        //Then
        Assert.assertEquals(30, result);
    }
}

