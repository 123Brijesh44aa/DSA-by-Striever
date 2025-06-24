package dp;

import java.util.Arrays;

public class FrogJump {

    // Recursion + Memoization
    private static int minCostFrogJump(int[]height,int n, int[]memo) {
        if (n == 0) {
            return 0;
        }

        if (memo[n] != -1){
            return  memo[n];
        }

        int left = minCostFrogJump(height, n - 1, memo) + Math.abs(height[n] - height[n - 1]);
        int minCost = left;
        if (n > 1) {
            int right = minCostFrogJump(height, n - 2, memo) + Math.abs(height[n] - height[n - 2]);
            minCost = Math.min(left, right);
        }
        memo[n] = minCost;
        return minCost;
    }


    // loop + memoization
    private static int minCostFrogJump_2(int[] height){
        int n = height.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i=1; i<n; i++){
            int firstStep = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int secondStep = Integer.MAX_VALUE;
            if (i>1){
                secondStep = dp[i-2] + Math.abs(height[i] - height[i-2]);
            }
            dp[i] = Math.min(firstStep,secondStep);
        }
        return dp[n-1];
    }

    // Optimized Space with Tabular/Bottom-up approach
    private static int minCost_optimal(int[] height){
        int n = height.length;
        int prev1 = 0;
        int prev2 = 0;
        for (int i=1; i<n; i++){
            int firstStep = prev1 + Math.abs(height[i] - height[i-1]);
            int secondStep = Integer.MAX_VALUE;
            if (i>1){
                secondStep = prev2 + Math.abs(height[i] - height[i-2]);
            }
            int curri = Math.min(firstStep,secondStep);
            prev2 = prev1;
            prev1 = curri;
        }
        return prev1;
    }



    public static void main(String[] args) {
        int[] height = {10,20,30,10};
        int n = height.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println("min cost is : "+minCostFrogJump(height, n-1, memo));
        System.out.println("min cost is : "+minCostFrogJump_2(height));
        System.out.println("min cost is : "+minCost_optimal(height));
    }
}
