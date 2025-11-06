package javaassignment;

public class Outer {

    String name = "Brijesh Mourya";

    void show() {
        System.out.println("name is : " + name);
    }

    class Inner {

        void display() {
            System.out.println(Outer.this.name);
            Outer.this.show();
        }
    }
}
