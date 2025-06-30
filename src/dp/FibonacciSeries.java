package dp;

import java.util.Arrays;

public class FibonacciSeries {

    // Recursive DP solution (memoization)
    // T(n) = O(n)
    // space = O(n) for Call Stack
    // space = O(n) for array
    private static int fib(int n, int[] dp){
        if (n <= 1){
            return n;
        }
        if (dp[n] != -1){
            return dp[n];
        }
        int result = fib(n-1, dp) + fib(n-2, dp);
        dp[n] = result;
        return result;
    }

    // Tabulation DP solution
    // T(n) = O(n)
    // space = O(n) for array only
    private static int fib_better(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // Tabulation DP solution (space optimized)
    // T(n) = O(n)
    // space = O(1)
    private static int fib_optimal(int n){
        int prev = 1;
        int prev2 = 0;
        for (int i=2; i<=n; i++){
            int curri = prev + prev2;
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("fibonacci of 6 is ( memoization ) : "+fib(n,dp));
        System.out.println("fibonacci of 6 is ( Tabulation : better ) : "+fib_better(n));
        System.out.println("fibonacci of 6 is ( Tabulation : space optimized ) : "+fib_optimal(n));

    }
}
