package javaassignment;

public class Human {

    String name;
    String address;
    int age;

    public Human(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Human(String name) {
        this.name = name;
        this.address = "jaipur";
        this.age = 21;
    }
}

class Student extends Human {

    int rollno;

    public Student(String name, String address, int age, int rollno) {
        super(name, address, age);
        this.rollno = rollno;
    }

    public Student(String name, int rollno) {
        super(name);
        this.rollno = rollno;
    }
}
