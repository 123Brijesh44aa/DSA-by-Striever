package dp;

import java.util.Arrays;

public class UnboundedKnapsack {

    /*
     * Unbounded Knapsack Problem:
     * Given a set of items, each with a weight and a value, and a knapsack with a
     * maximum weight capacity,
     * determine the maximum value you can obtain by putting items into the
     * knapsack.
     * You can use an unlimited number of instances of each item (i.e., each item
     * can be chosen multiple times).
     *
     * Example:
     * Items: weights = [2, 3, 4], values = [4, 5, 7]
     * Capacity: 7
     * 
     * Try including items multiple times to stay within capacity 7:
     * 
     * ✅ Option 1: Two items of weight 3 (3 + 3 = 6)
     * 2 × Item 2 (value = 2 × 5 = 10), remaining = 1 → can't add anything more.
     * 
     * Total = 10
     * 
     * ✅ Option 2: Item 1 (2) + Item 3 (4) = 6
     * Value = 4 + 7 = 11
     * 
     * ✅ Option 3: 3 × Item 1 = 6
     * Value = 3 × 4 = 12
     * 
     * ✅ Option 4: Item 1 (2) + Item 2 (3) = 5, can add Item 1 again (2) → total
     * weight = 7
     * Value = 4 + 5 + 4 = 13
     * 
     * ✅ Best combination:
     * 
     * Item 2 (3) + 2 × Item 1 (2 + 2) = 7
     * 
     * Value = 5 + 4 + 4 = 13
     */

    // RECURSION
    private static int maxProfit(int[] weight, int[] value, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (weight[n - 1] <= w) {
            return Math.max(
                    value[n - 1] + maxProfit(weight, value, w - weight[n - 1], n),
                    maxProfit(weight, value, w, n - 1));
        } else {
            return maxProfit(weight, value, w, n - 1);
        }
    }

    // MEMOIZATION
    private static int helper(int[] weight, int[] value, int w, int n, int[][] dp) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        if (weight[n - 1] <= w) {
            return dp[n][w] = Math.max(
                    value[n - 1] + helper(weight, value, w - weight[n - 1], n, dp),
                    helper(weight, value, w, n - 1, dp));
        } else {
            return dp[n][w] = helper(weight, value, w, n - 1, dp);
        }

    }

    private static int maxProfit_memo(int[] weight, int[] value, int w) {
        int n = weight.length;
        int[][] dp = new int[n + 1][w + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(weight, value, w, n, dp);
    }

    // BOTTOM UP SOLUTION
    private static int maxProfit_optimal(int[] weight, int[] value, int w) {
        int n = weight.length;
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int[] wt = { 2, 3, 4 };
        int[] val = { 4, 5, 7 };
        int w = 7;
        int n = wt.length;
        System.out.println("max profit is : " + maxProfit(wt, val, w, n));
        System.out.println("max profit (memo) is : " + maxProfit_memo(wt, val, w));
        System.out.println("max profit (bottom up) is : " + maxProfit_optimal(wt, val, w));
    }
}



