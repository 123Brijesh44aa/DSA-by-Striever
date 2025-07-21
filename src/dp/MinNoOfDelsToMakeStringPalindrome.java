package dp;

public class MinNoOfDelsToMakeStringPalindrome {

    // problem statement :
    // minimum number of deletions in a String to make it a Palindrome
    // Example :
    // a = "agbcba"
    // output = 1
    // Explanation :
    // we have to remove only 'g' (1 character) to make String a Palindrome

    // Approach :
    // Step 1 - find the longest Palindromic subsequence (LPS)
    // Step 2 - return (a.length - lps)

    private static int minNoOfDelsToMakeStringPalindrome(String a) {
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
        int lps = dp[n][m];
        return (n - lps);
    }

    public static void main(String[] args) {
        String a = "agbcba";
        System.out.println(
                "minimum number of deletions to make it Palindrome is : " + minNoOfDelsToMakeStringPalindrome(a));
    }
}
