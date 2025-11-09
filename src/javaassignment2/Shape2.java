package javaassignment2;

public interface Shape2 {
    double area();
    double perimeter();
}

class Circle2 implements Shape2 {
    int radius;
    public Circle2(int radius){
        this.radius = radius;
    }
    @Override
    public double area() {
        return 2*3.14*radius;
    }

    @Override
    public double perimeter() {
        return 3.14*radius*radius;
    }
}
