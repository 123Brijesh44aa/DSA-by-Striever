package dp;

public class CoinChange518 {

    // problem statement
    // we're given a coin[] array and a sum variable
    // our goal is to:
    // find maximum no of way ( or total no of ways ) to get given sum
    // Example :
    // i/p => coin[] = {1,2,3}, sum = 5
    // op = 5
    // Explanation :
    // 1 + 1 + 1 + 1 + 1
    // 1 + 1 + 1 + 2
    // 1 + 2 + 2
    // 1 + 1 + 3
    // 2 + 3
    // Total ways = 5

    // approach :
    // if we clearly see this problem is kinda similar to "count of subset sum
    // (variant of 0/1knapsack)"

    private static int coinChangeMaxCount(int[] coin, int sum) {
        int n = coin.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coin[i - 1] <= j) {
                    // 2 choices : 1.include 2.exclude
                    int include = dp[i][j - coin[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = include + exclude;
                } else {
                    int exclude = dp[i - 1][j];
                    dp[i][j] = exclude;
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] coin = { 1, 2, 3, 4 };
        int sum = 99999999;
        System.out.println("maximum no of ways : " + coinChangeMaxCount(coin, sum));
    }
}
