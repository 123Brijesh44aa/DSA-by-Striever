package recursions.basics;

public class Factorial {

    int factorial(int n){
        if (n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }

    // using for loop
    static int factorial2(int n){
        int p = 1;
        for (int i = 1; i <= n; i++) {
            p *= i;
        }
        return p;
    }

    public static void main(String[] args) {
        Factorial fact = new Factorial();
        System.out.println(fact.factorial(5));
        System.out.println(factorial2(5));
    }
}
