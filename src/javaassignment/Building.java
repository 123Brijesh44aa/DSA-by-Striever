package javaassignment;

public class Building {

    int age;
    String name;

    public Building(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Building(int age) {
        this.age = age;
        this.name = "Brijesh";
    }
}

class House extends Building {

    int address;

    public House(int age, String name, int address) {
        super(age, name);
        this.address = address;
    }

    public House(int age) {
        super(age);
        this.address = address;
    }

}
