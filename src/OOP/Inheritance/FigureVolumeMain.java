package OOP.Inheritance;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FigureVolumeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Shape cylinder1 = new Cylinder(1, 1);
        Ball ball1 = new Ball(100);
        System.out.println("Compare Shape to Ball: " + cylinder1.compareTo(ball1));
        System.out.println("Compare Ball to Shape: " + ball1.compareTo(cylinder1));

        Box box = new FigureVolumeMain().createBox();

        boolean isExit = false;
        while (!isExit) {
            System.out.println("""
                    [1] - Create a Cylinder\s
                    [2] - Create a Ball\s
                    [3] - Create a Pyramid\s
                    [4] - Exit
                    """);
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Enter a radius: ");
                    double cylinderRadius = scanner.nextDouble();
                    System.out.print("Enter a height: ");
                    double height = scanner.nextDouble();
                    Shape cylinder = new Cylinder(cylinderRadius, height);
                    System.out.println("Left volume: " + box.add(cylinder) + "\n");
                }
                case 2 -> {
                    System.out.print("Enter a radius: ");
                    double ballRadius = scanner.nextDouble();
                    Shape ball = new Ball(ballRadius);
                    System.out.println("Left volume: " + box.add(ball) + "\n");
                }
                case 3 -> {
                    System.out.print("Enter s: ");
                    double s = scanner.nextDouble();
                    System.out.print("Enter h: ");
                    double h = scanner.nextDouble();
                    Shape pyramid = new Pyramid(s, h);
                    System.out.println("Left volume: " + box.add(pyramid) + "\n");
                }
                case 4 -> isExit = true;
                default -> System.out.println("Unknown input");
            }
        }

    }

    private Box createBox() {
        Scanner scanner = new Scanner(System.in);
        Box box;
        double boxDefaultCapacity = 1000;

        try {
            System.out.print("Enter a Box volume: ");
            double boxVolume =  scanner.nextDouble();
            box = new Box(boxVolume);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
            System.out.println("Box created with default capacity: " + boxDefaultCapacity + "\n");
            box = new Box(boxDefaultCapacity);
        }
        return box;
    }
}

interface Shape extends Comparable<Shape> {
    double getVolume();

    @Override
    default int compareTo(Shape o) {
        return Double.compare(getVolume(), o.getVolume());
    }
}

abstract class SolidOfRevolution implements Shape {
    public double radius;

    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }

    @SuppressWarnings(value = "unused")
    public double getRadius() {
        return radius;
    }
}

class Cylinder extends SolidOfRevolution {
    public double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}

class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        super(radius);
    }

    @Override
    public double getVolume() {
        return (4d / 3d) * Math.PI * Math.pow(radius, 3);
    }
}

class Pyramid implements Shape {
    public double s;
    public double h;

    public Pyramid(double s, double h) {
        this.s = s;
        this.h = h;
    }

    @Override
    public double getVolume() {
        return (1d / 3d) * s * h;
    }
}

class Box implements Shape {
    private final ArrayList<Shape> shapeList = new ArrayList<>();
    private final double volume;

    public Box(double volume) {
        this.volume = volume;
    }

    public double add (Shape shape) {
        if (calculateEmptyVolume(shapeList) >= shape.getVolume()) {
            shapeList.add(shape);
            System.out.println("\n" + shape.getClass().getSimpleName() + " was added to Box");
        } else {
            System.out.println("\nThere is not enough place in Box");
        }
        return calculateEmptyVolume(shapeList);
    }

    private double calculateEmptyVolume(ArrayList<Shape> shapeList) {
        List<Double> volumeList = shapeList.stream().map(Shape :: getVolume).toList();
        double volumeSum = 0;
        for (Double aDouble : volumeList) {
            volumeSum += aDouble;
        }
        return this.volume - volumeSum;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}