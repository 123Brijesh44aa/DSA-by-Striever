package dp;

import java.util.Arrays;

public class MaxSumOfNonAdjacentItems {

    // brute force ( 2 for loops)
    // private int maxSum(int[] list) {
    // int n = list.length;
    // int maxSum = Integer.MIN_VALUE;
    // if (n < 3) {
    // return -1;
    // }
    // for (int i = 0; i < n; i++) {
    // for (int j = i + 2; j < n; j++) {
    // maxSum = Math.max(maxSum, list[i] + list[j]);
    // if (j == n - 1) {
    // break;
    // }
    // }
    // }
    // return maxSum;
    // }

    private int maxSum(int index, int[] list) {
        int n = list.length;
        if (index >= n) {
            return 0;
        }
        int pick = list[index] + maxSum(index + 2, list);
        int skip = maxSum(index + 1, list);
        return Math.max(pick, skip);
    }

    // USING MEMOIZATION
    private int helper(int index, int[] dp, int[] arr) {
        if (index == 0)
            return arr[0];
        if (index < 0)
            return 0;
        if (dp[index] != -1) {
            return dp[index];
        }
        int pick = arr[index] + helper(index - 2, dp, arr);
        int notPick = 0 + helper(index - 1, dp, arr);
        return dp[index] = Math.max(pick, notPick);
    }

    private int maxSum_memo(int[] arr) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return helper(arr.length - 1, dp, arr);
    }

    // Bottom up with memoization
    private int maxSum_optimal(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return arr[0];
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            int pick = arr[i] + dp[i - 2];
            int notPick = arr[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }

    // Tabular + space optimized
    private int maxSum_spaceOptimized(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }
        int prev2 = arr[0];
        int prev = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            int pick = arr[i] + prev2;
            int notPick = prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 9 };
        System.out.println("max sum is (memo): " + new MaxSumOfNonAdjacentItems().maxSum_memo(arr));
        System.out.println("max sum is : " + new MaxSumOfNonAdjacentItems().maxSum(0, arr));
        arr = new int[] { 1, 2, 4 };
        System.out.println("max sum is (memo):" + new MaxSumOfNonAdjacentItems().maxSum_memo(arr));
        System.out.println("max sum is : " + new MaxSumOfNonAdjacentItems().maxSum(0, arr));
        System.out.println("max sum is : " + new MaxSumOfNonAdjacentItems().maxSum(0, new int[] { 1, 2, 3, 4 }));
        System.out.println("max sum is (memo):" + new MaxSumOfNonAdjacentItems().maxSum_memo(new int[] { 1, 2, 3, 4 }));

        System.out.println("max sum (memo+tabular)  is : "
                + new MaxSumOfNonAdjacentItems().maxSum_optimal(new int[] { 1, 2, 3, 4, 5 }));

        System.out.println("max sum (tabular + space optimized)  is : "
                + new MaxSumOfNonAdjacentItems().maxSum_spaceOptimized(new int[] { 1, 2, 3, 4, 5 }));

    }
}
