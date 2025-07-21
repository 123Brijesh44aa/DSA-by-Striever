package dp;

public class LongestPalindromicSubsequence {

    // problem statement :
    // find the longest subsequence within a given String that is also a Palindrome
    // String a = "agbcba"
    // output = 5
    // explanation : LPS = "abcba" and length = 5

    // Approach :
    // LPS = LCS(String a, reverse(a))

    private static int lps(String a) {
        String b = new StringBuilder(a).reverse().toString();
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        String a = "agbcba";
        System.out.println("longest palindromic subsequence is : " + lps(a));
    }
}
