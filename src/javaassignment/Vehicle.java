package javaassignment;

public class Vehicle {

    void move() {
        System.out.println("move");
    }

}

class Car extends Vehicle {

    @Override
    void move() {
        super.move();
    }
}
