package javaassignment;

public class Animal {

    void makeSound() {
        System.out.println("animal sound");
    }

}

class Dog extends Animal {

    @Override
    void makeSound() {
        super.makeSound();
    }

}
