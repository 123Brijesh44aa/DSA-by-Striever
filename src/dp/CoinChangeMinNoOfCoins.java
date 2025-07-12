package dp;

import java.util.Arrays;

public class CoinChangeMinNoOfCoins {

    // problem Description :
    // We're given a coin array and a sum variable.
    // our goal is to :
    // find the minimum number of coins to get the given sum
    // Example :
    // i/p => coin[] = {1,2,3} sum = 5
    // o/p => 2 coins
    // Explanation :
    // 1 + 1 + 1 + 1 + 1 => took 5 coins
    // 1 + 1 + 1 + 2 => took 4 coins
    // 1 + 2 + 2 => took 3 coins
    // 1 + 1 + 3 => took 3 coins
    // 2 + 3 => took 2 coins
    // min coins it took to get given (sum=5) = 2 coins
    // output = 2

    // RECURSION
    private static int minCoins_rec(int[] coin, int sum, int n) {
        if (n == 0) {
            if (sum % coin[0] == 0) {
                return sum / coin[0];
            } else {
                return (int) 1e9;
            }
        }
        int take = Integer.MAX_VALUE;
        if (coin[n - 1] <= sum) {
            take = 1 + minCoins_rec(coin, sum - coin[n - 1], n);
        }
        int notTake = minCoins_rec(coin, sum, n - 1);
        return Math.min(take, notTake);
    }

    // MEMOIZATION WITH RECURSION
    private static int helper(int[] coin, int sum, int n, int[][] memo) {
        if (sum == 0) {
            return 0;
        }
        if (n == 0) {
            return (int) 1e9;
        }
        if (memo[n][sum] != -1) {
            return memo[n][sum];
        }
        if (coin[n - 1] <= sum) {
            // include
            int include = 1 + helper(coin, sum - coin[n - 1], n, memo);
            // exclude
            int exclude = helper(coin, sum, n - 1, memo);
            memo[n][sum] = Math.min(include, exclude);
        } else {
            memo[n][sum] = helper(coin, sum, n - 1, memo);
        }
        return memo[n][sum];
    }

    private static int minCoins_memo(int[] coin, int sum) {
        int n = coin.length;
        int[][] memo = new int[n + 1][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int result = helper(coin, sum, n, memo);
        return result >= (int) 1e9 ? -1 : result;
    }

    private static int minCoins(int[] coin, int sum) {
        int n = coin.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coin[i - 1] <= j) {
                    // Include the coin: 1 + dp[i][j - coin]
                    // Exclude the coin: dp[i - 1][j]
                    dp[i][j] = Math.min(1 + dp[i][j - coin[i - 1]], dp[i - 1][j]);
                } else {
                    // can't include the coin
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[n][sum];
    }

    public static void main(String[] args) {
        int[] coin = { 1, 2, 3, };
        int sum = 130;
        System.out.println("minimum coin it took to get given sum is : " + minCoins(coin, sum));

        System.out.println("minimum coin it took to get given sum is : " + minCoins_rec(coin, sum, coin.length));
    }
}
