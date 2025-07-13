package dp;

import java.util.Arrays;

public class LongestCommonSubsequence1143 {

    // Problem description

    // Given two strings text1 and text2, return the length of their longest common
    // subsequence. If there is no common subsequence, return 0.

    // A subsequence of a string is a new string generated from the original string
    // with some characters (can be none) deleted without changing the relative
    // order of the remaining characters.

    // For example, "ace" is a subsequence of "abcde".
    // A common subsequence of two strings is a subsequence that is common to both
    // strings.

    // Example 1:

    // Input: text1 = "abcde", text2 = "ace"
    // Output: 3
    // Explanation: The longest common subsequence is "ace" and its length is 3.
    // Example 2:

    // Input: text1 = "abc", text2 = "abc"
    // Output: 3
    // Explanation: The longest common subsequence is "abc" and its length is 3.
    // Example 3:

    // Input: text1 = "abc", text2 = "def"
    // Output: 0
    // Explanation: There is no such common subsequence, so the result is 0.

    // Constraints:

    // 1 <= text1.length, text2.length <= 1000
    // text1 and text2 consist of only lowercase English characters.

    // Recursive Approach
    private static int lcs(String x, String y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return 1 + lcs(x, y, m - 1, n - 1);
        } else {
            return Math.max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
        }
    }

    // top Down Approach (Memoization)
    private static int helper(String x, String y, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return dp[m][n] = 1 + helper(x, y, m - 1, n - 1, dp);
        } else {
            return dp[m][n] = Math.max(helper(x, y, m, n - 1, dp), helper(x, y, m - 1, n, dp));
        }
    }

    private static int lcs_td(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(x, y, m, n, dp);
    }

    // BOTTOM UP APPROACH
    private static int lcs_optimal(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] dp = new int[m + 1][n + 1]; // default:filled with zeros
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String x = "axyt";
        String y = "ayzx";
        int m = x.length();
        int n = y.length();
        System.out.println("length of longest common subsequence  is : " + lcs(x, y, m, n));
        System.out.println("length of longest common subsequence (top down) is : " + lcs_td(x, y));
        System.out.println("length of longest common subsequence (Bottom Up) is : " + lcs_optimal(x, y));
        x = "abc";
        y = "albdc";
        m = x.length();
        n = y.length();
        System.out.println("length of longest common subsequence is : " + lcs(x, y, m, n));
        System.out.println("length of longest common subsequence (top down) is : " + lcs_td(x, y));
        System.out.println("length of longest common subsequence (Bottom Up) is : " + lcs_optimal(x, y));
    }
}
