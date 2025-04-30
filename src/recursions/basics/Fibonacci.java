package recursions.basics;

public class Fibonacci {
    int fibonacciNumber(int n){
        if (n == 0){ return 0; }
        if (n == 1){ return 1; }
        return fibonacciNumber(n-2) + fibonacciNumber(n-1);
    }
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacciNumber(7));
    }
}
