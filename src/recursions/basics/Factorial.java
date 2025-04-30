package recursions.basics;

public class Factorial {

    int factorial(int n){
        if (n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        Factorial fact = new Factorial();
        System.out.println(fact.factorial(10));
    }
}
