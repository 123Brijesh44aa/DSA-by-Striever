package javaassignment;

public class Parent {

    void display() {
        System.out.println("parent display");
    }

    public Parent() {
        System.out.println("this is parent class constructor");
    }
}

class Child extends Parent {

    @Override
    void display() {
        System.out.println("child display");
    }

    Child() {
        super();
        System.out.println("child class constructor");
    }

    void show() {
        this.display();
        super.display();
    }

}
