package dp;

/**
 * The MinimumSubsetSumDifference class provides a method to solve the "Minimum
 * Subset Sum Difference" problem.
 *
 * Problem Description:
 * Given an array of positive integers, partition it into two subsets such that
 * the absolute difference between the sums of the subsets is minimized.
 * The function should return the minimum possible difference.
 *
 * Example 1:
 * Input: arr = [1, 6, 11, 5]
 * Output: 1
 * Explanation: The array can be partitioned as [1, 6, 5] and [11]. The sums are
 * 12 and 11, and the difference is 1.
 *
 * Example 2
 * Input: arr = [3, 1, 4, 2, 2, 1]
 * Output: 1
 * Explanation: The array can be partitioned as [3, 1, 1] and [4, 2, 2]. The
 * sums are 5 and 8, and the difference is 3.
 * However, the best partition is [3, 2, 2] and [4, 1, 1], with sums 7 and 6,
 * and the difference is 1.
 *
 */

// Approach:
/*
 * Problem Restatement:
 * Given an array of positive integers, partition it into two subsets such that
 * the absolute difference between the sums of the subsets is minimized.
 *
 * Let:
 * - The total sum of the array be 'range'.
 * - The sums of the two subsets be 'sum1' and 'sum2'.
 *
 * We want to minimize: abs(sum1 - sum2)
 *
 * Observation:
 * - sum1 + sum2 = range
 * - abs(sum1 - sum2) = abs(range - 2*sum1) [since sum2 = range - sum1]
 *
 * Goal:
 * - Find a subset with sum 'sum1' such that abs(range - 2*sum1) is minimized.
 * - Since both subsets are formed from the array, sum1 can take any value from
 * 0 up to range/2 (as the other subset will have the remaining elements).
 *
 * Approach:
 * 1. Calculate the total sum (range) of the array.
 * 2. Use dynamic programming to find all possible subset sums up to range/2.
 * - For each possible sum 's' (from 0 to range/2), check if there exists a
 * subset with sum 's'.
 * 3. For all valid subset sums 's', compute abs(range - 2*s) and keep track of
 * the minimum.
 *
 * Why only up to range/2?
 * - Because for any sum1 > range/2, sum2 < range/2, and the difference will be
 * the same as swapping the subsets.
 *
 * Summary:
 * - The problem reduces to finding the largest subset sum <= range/2.
 * - The minimum difference is then range - 2*(that subset sum).
 */
public class MinimumSubsetSumDifference {

    private static int minSubsetSumDiff(int[] arr) {
        int n = arr.length;
        int totalSum = 0; // range
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        int target = totalSum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1]; // default -> false
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < target + 1; i++) {
            if (dp[n][i]) {
                minDiff = Math.min(minDiff, totalSum - 2 * i);
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 7 };
        System.out.println("minimum subset sum difference is : " + minSubsetSumDiff(arr));
    }
}