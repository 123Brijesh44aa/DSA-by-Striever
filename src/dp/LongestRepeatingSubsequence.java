package dp;

public class LongestRepeatingSubsequence {

    // problem statement
    // find longest repeating subsequence

    private static int findLRS(String s) {
        String a = s;
        String b = s;
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1) && (i != j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "AABEBCDD";
        System.out.println("length of longest repeating subsequence is : " + findLRS(s));
    }
}
