package dp;

import java.util.Arrays;

public class PalindromePartitioning {

    // Problem Statement
    // Given a String S, the task is to find the minimum number of cuts(partitions)
    // needed for
    // a Palindrome Partitioning of given String.
    // A Partitioning of the String is a Palindrome Partitioning if every sub string
    // of the partition
    // is a palindrome.
    // Example :
    // i/p = String = geek
    // i/o = 2
    // Explanation :
    // g | ee | k
    // i/p = String = aaa
    // i/o = 0
    // Explanation : String is already palindrome so minimum partition is zero

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Recursive approach
    private static int palindromePartitioning_recursive(String s, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int tempAns = 1 + palindromePartitioning_recursive(s, i, k) + palindromePartitioning_recursive(s, k + 1, j);
            if (tempAns < min) {
                min = tempAns;
            }
        }
        return min;
    }

    // Memoization
    private static int helper(String s, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int tempAns = 1 + helper(s, i, k, dp) + helper(s, k + 1, j, dp);
            if (tempAns < min) {
                min = tempAns;
            }
        }
        return dp[i][j] = min;
    }

    private static int palindromePartitioning_memo(String s, int i, int j) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(s, i, j, dp);
    }

    // Memoization + Space Optimization
    private static int helper_optimized(String s, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left;
            int right;
            if (dp[i][k] != -1) {
                left = dp[i][k];
            } else {
                left = helper_optimized(s, i, k, dp);
                dp[i][k] = left;
            }

            if (dp[k + 1][j] != -1) {
                right = dp[k + 1][j];
            } else {
                right = helper_optimized(s, k + 1, j, dp);
                dp[k + 1][j] = right;
            }

            int tempAns = 1 + left + right;

            if (tempAns < min) {
                min = tempAns;
            }
        }
        return dp[i][j] = min;
    }

    private static int palindromePartitioning_memo_spaceOptimized(String s, int i, int j) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper_optimized(s, i, j, dp);
    }

    public static void main(String[] args) {
        String string = "geek";
        int i = 0;
        int j = string.length() - 1;
        System.out.println(
                "minimum number of partitions are (Recursive) : " + palindromePartitioning_recursive(string, i, j));
        System.out.println("minimum number of partitions are (Memo) : " + palindromePartitioning_memo(string, i, j));
        System.out.println("minimum number of partitions are (Memo + space optimized) : "
                + palindromePartitioning_memo_spaceOptimized(string, i, j));

    }
}
