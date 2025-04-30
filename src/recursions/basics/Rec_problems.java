package recursions.basics;

public class Rec_problems {

    // problem 1:
    // print name 5 times
    void printName(int i, int n){
        if(i > n){
            return;
        }
        System.err.println("Brijesh");
        printName(i+1, n);
    }

    // problem 2:
    // print linearly from 1 to n
    void printLinear(int i, int n){
        if (i> n){
            return;
        }
        System.err.println(i);
        printLinear(i+1, n);
    }
    // problem 3:
    // print in terms of n to 1
    void printQuadratic(int i, int n){
        if (i == n){
            System.err.println(i);
           return;
        }
        System.err.println(n);
        printQuadratic(i, n-1);
    }

    // problem 4:
    // print linearly from 1 to n (but by backtrack/ without using +, - signs )
    void printCubic(int i, int n){

    }
    public static void main(String[] args) {
        Rec_problems rec_problems = new Rec_problems();
        rec_problems.printName(1, 5);
        rec_problems.printLinear(1, 10);
        rec_problems.printQuadratic(1, 10);
    }
}
