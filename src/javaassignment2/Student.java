package javaassignment2;

public class Student {
    private int id;
    private String name;
    private String grades;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, String grades){
        this.id = id;
        this.name = name;
        this.grades = grades;
    }
}
