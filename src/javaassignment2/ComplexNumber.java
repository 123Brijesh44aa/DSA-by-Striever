package javaassignment2;

public class ComplexNumber {
    private int a;
    private int b;

    public ComplexNumber(int a, int b){
        this.a = a;
        this.b = b;
    }

    public ComplexNumber(ComplexNumber complexNumber){
        this.a = complexNumber.a;
        this.b = complexNumber.b;
    }
}
