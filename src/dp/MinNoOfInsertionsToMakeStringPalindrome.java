package dp;

public class MinNoOfInsertionsToMakeStringPalindrome {

    // This Problem is same as " Min No of deletions to make a String Palindrome"
    // and Code is Exactly Same

    public int minInsertions(String s) {
        String b = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int longestPalindromicSubsequence = dp[n][m];

        return (n - longestPalindromicSubsequence);

    }

    public static void main(String[] args) {

    }
}
