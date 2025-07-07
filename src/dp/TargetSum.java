package dp;

public class TargetSum {

    private static int targetSum(int[] arr, int targetSum) {
        int n = arr.length;
        int totalSum = 0;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            if (arr[i] == 0) {
                zeroCount++;
            }
        }
        if (totalSum < Math.abs(targetSum)) {
            return 0;
        }
        if (((targetSum + totalSum) < 0) || ((targetSum + totalSum) % 2 != 0)) {
            return 0;
        }
        int s1 = (targetSum + totalSum) / 2;

        int[][] dp = new int[n + 1][s1 + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < s1 + 1; j++) {
                if (arr[i - 1] == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (arr[i - 1] <= j) {
                    int include = dp[i - 1][j - arr[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = include + exclude;
                } else {
                    int exclude = dp[i - 1][j];
                    dp[i][j] = exclude;
                }
            }
        }

        return (int) (dp[n][s1] * Math.pow(2, zeroCount));
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1 };
        int targetSum = 1;
        arr = new int[] { 1, 1, 1, 1, 1 };
        targetSum = 3;
        System.out.println("total count of target sum is : " + targetSum(arr, targetSum));
    }
}
