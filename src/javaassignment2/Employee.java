package javaassignment2;

public class Employee {
    private String name;
    private int id;
    private String designation;
    private double salary;

    public Employee(String name){
        this.name = name;
    }

    public Employee(String name, int id, String designation){
        this.name = name;
        this.id = id;
        this.designation = designation;
    }

    public Employee(String name, int id, double salary){
        this(name,id,"India");
        this.salary = salary;
    }

    public Employee(String name,double salary){
        this(name);
        this.salary = salary;
    }
}
