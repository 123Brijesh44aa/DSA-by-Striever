package dp;

import java.util.Arrays;

public class ZeroOneKnapSack {

    // Problem Statement:
// Given a set of items, each with a weight and a value, and a knapsack with a fixed capacity,
// determine the maximum total value that can be obtained by selecting a subset of the items
// such that the total weight does not exceed the knapsack's capacity.
//
// Input:
// - int[] weight: an array where weight[i] is the weight of the i-th item
// - int[] value: an array where value[i] is the value of the i-th item
// - int capacity: the maximum weight the knapsack can carry
//
// Constraint:
// - Each item can be included at most once (0/1 property).
//
// Goal:
// - Select items to maximize the total value without exceeding the knapsack's capacity.

    private static int maxProfit(int[] weight, int[] value, int w, int n) {
        // w - capacity // n - length of wt[] and val[]
        if (n == 0 || w == 0){
            return 0;
        }
        if (weight[n-1] > w){
            return maxProfit(weight,value,w,n-1);
        } else { // (weight[n - 1] <= w)
            return Math.max(
                    value[n-1] + maxProfit(weight,value,w-weight[n-1], n-1),
                    maxProfit(weight,value,w,n-1)
            );
        }
    }

    // memoization
    private static int helper(int[]weight,int[]value,int w,int n,int[][]dp){
        if (n == 0 || w == 0){
            return 0;
        }
        if (dp[n][w] != -1){
            return dp[n][w];
        }
        if (weight[n-1] > w){
            return dp[n][w] = helper(weight,value,w,n-1,dp);
        } else { // weight[n-1] <= w
            return dp[n][w] = Math.max(
                    value[n-1] + helper(weight,value,w-weight[n-1],n-1,dp),
                    helper(weight,value,w,n-1,dp)
            );
        }
    }
    private static int maxProfit_memo(int[] weight, int[] value, int w, int n){
        int [][] dp = new int[n+1][w+1];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(weight,value,w,n,dp);
    }

    // Bottom up approach
    private static int maxProfit_optimal(int[] weight, int[] value, int w, int n){
        int[][] dp = new int[n+1][w+1];
        for (int i = 0; i<n+1; i++){
            for (int j = 0; j<w+1; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i<n+1; i++){
            for (int j = 1; j<w+1; j++){
                if (weight[i-1] <= j) {
                    dp[i][j] = Math.max(value[i-1] + dp[i-1][j-weight[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int w = 7;
        int n = wt.length;
        System.out.println("max profit is : "+ maxProfit(wt,val,w,n));
        System.out.println("max profit is (memo) : "+ maxProfit_memo(wt,val,w,n));
        System.out.println("max profit is (bottom up) : "+ maxProfit_optimal(wt,val,w,n));
    }
}
