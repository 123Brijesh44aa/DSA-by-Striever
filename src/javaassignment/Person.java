package javaassignment;

public class Person {

    int age;
    String name;

    public Person(int age, String name) {
        this.name = name;
        this.age = age;
    }
}

class Employee extends Person {

    int age;
    String name;
    double salary;

    public Employee(int age, String name, double salary) {
        super(age, name);
        this.salary = salary;
    }

}
