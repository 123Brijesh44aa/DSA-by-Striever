package dp;

public class CountTheNoOfSubsetWithGivenDiff {

    // problem statement
    // count the number of subset with a given difference
    // Example :
    // arr[] = {1,1,2,3} , diff = 1
    // sub1 = {1,1,2}, sub2 = {3} => abs ( sum(sub1) - sum(sub2) ) = abs(4-3) = 1 =>
    // count = 1
    // sub1 = {1,2}, sub2 = {1,3} => abs ( sum(sub1) - sum(sub2) ) = abs(3-4) = 1 =>
    // count = 2
    // sub1 = {1,3}, sub2 = {1,2} => abs ( sum(sub1) - sum(sub2) ) = abs(4-3) = 1 =>
    // count = 3
    // return count => 3
    // output = 3

    // Approach :
    // check the notebook

    private static int countTheNoOfSubsetWithGivenDiff(int[] arr, int diff) {
        int n = arr.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        int s1 = (diff + totalSum) / 2;
        // now our goal becomes to find the count of subset sum with sum = s1;
        int[][] dp = new int[n + 1][s1 + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s1 + 1; j++) {
                if (arr[i - 1] <= j) {
                    int include = dp[i - 1][j - arr[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = include + exclude;
                } else {
                    int exclude = dp[i - 1][j];
                    dp[i][j] = exclude;
                }
            }
        }
        return dp[n][s1];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3 };
        int diff = 1;
        System.out
                .println("total number of subset with given diff are : " + countTheNoOfSubsetWithGivenDiff(arr, diff));
    }
}
