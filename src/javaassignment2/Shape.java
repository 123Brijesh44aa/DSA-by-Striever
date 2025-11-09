package javaassignment2;

public abstract class Shape {

    String color;
    public Shape(String color){
        this.color = color;
    }
}

class Circle extends Shape{
    double radius;
    double length;
    double width;


    public Circle(String color,double radius, double length, double width) {
        super(color);
        this.length = length;
        this.radius = radius;
        this.width = width;
    }
}
