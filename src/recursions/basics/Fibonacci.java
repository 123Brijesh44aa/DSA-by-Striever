package recursions.basics;

import java.util.Arrays;


public class Fibonacci {

    static class FibonacciOptimized{
        static int[]arr; // [0,0,0,0,0,0,0,0,0]
        static int fib(int n){
            if (n<=1){
                arr[n] = n;
                return n;
            }
            else {
                if (arr[n-2] == -1){
                    arr[n-2] = fib(n-2);
                }
                if (arr[n-1] == -1){
                    arr[n-1] = fib(n-1);
                }
                return arr[n-2] + arr[n-1];
            }
        }
    }

    int fibonacciNumber(int n){
        if (n == 0){ return 0; }
        if (n == 1){ return 1; }
        return fibonacciNumber(n-2) + fibonacciNumber(n-1);
    }

    // Fibonacci Series using For loop
    int fibonacci_for(int n){
        int t0 = 0;
        int t1 = 1;
        int s = 0;
        if (n <= 1) return n;
        for (int i=2; i<=n; i++){
            s = t0 + t1;
            t0 = t1;
            t1 = s;
        }
        return s;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacciNumber(7));
        System.out.println(fibonacci.fibonacci_for(7));


        // Optimized (Memorization) approach
        int n = 7;
        FibonacciOptimized.arr = new int[n+1];
        for (int i=0; i<=n; i++){
            FibonacciOptimized.arr[i] = -1;
        }
        int fibUsingMemorization = FibonacciOptimized.fib(n);
        System.out.println("Fibonacci Number using Memorization : "+fibUsingMemorization);

    }
}
