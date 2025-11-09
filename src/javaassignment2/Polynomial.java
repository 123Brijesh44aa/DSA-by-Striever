package javaassignment2;

public class Polynomial {
    private int c1;
    private int c2;
    private int c3;

    public Polynomial(int c1, int c2, int c3){
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    public void display(){
        System.out.println(c1+"x^2 + "+c2+"x + "+c3);
    }

    public static void main(String[] args) {
        Polynomial p = new Polynomial(4,8,33);
        p.display();
    }
}


