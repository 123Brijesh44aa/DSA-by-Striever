package dp;

public class PrintingLCS {

    /*
     * ====================================================================
     * APPROACH: Finding the Longest Common Subsequence
     * ====================================================================
     *
     * The overall strategy uses dynamic programming. It's a two-step process:
     * 1. Fill a table to calculate the LENGTH of the LCS.
     * 2. Backtrack through the table to RECONSTRUCT the actual LCS string.
     *
     * --------------------------------------------------------------------
     * Step 1: Build the DP Table (Calculating Length)
     * --------------------------------------------------------------------
     * We create a 2D array, `dp[n+1][m+1]`, where `dp[i][j]` will hold the
     * length of the LCS for the first `i` characters of string `X` and the
     * first `j` characters of string `Y`.
     *
     * - If characters match (X[i-1] == Y[j-1]):
     * The LCS is one character longer than the LCS of the strings without
     * these characters.
     * -> dp[i][j] = 1 + dp[i-1][j-1];
     *
     * - If characters do NOT match (X[i-1] != Y[j-1]):
     * The LCS is the longest one we've found so far by either ignoring
     * the current character of X or the current character of Y.
     * -> dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
     *
     * --------------------------------------------------------------------
     * Step 2: Reconstruct the LCS String (Backtracking)
     * --------------------------------------------------------------------
     * We start from the bottom-right corner of the table (`dp[n][m]`) and
     * trace our way back to the top-left to build the string.
     *
     * - If characters match (X[i-1] == Y[j-1]):
     * This character is part of our LCS. We add it to our result and
     * move diagonally up-left in the table (`i--`, `j--`).
     *
     * - If characters do NOT match:
     * We move in the direction of the larger value in the `dp` table.
     * If `dp[i-1][j]` (top) > `dp[i][j-1]` (left), we move up (`i--`).
     * Otherwise, we move left (`j--`).
     *
     * - Final Step:
     * This process builds the string in reverse. The last step is to
     * reverse the constructed string to get the final answer.
     */

    private static String printingLCS(String x, String y) {

        // step 1
        int n = x.length();
        int m = y.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        // step 2
        int i = n;
        int j = m;
        // String s = "";
        StringBuilder s = new StringBuilder();
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                s.append(x.charAt(i - 1));
                i--;
                j--;
            } else { // if x[i-1] and y[j-1] are not equal
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        // step 3
        s.reverse();
        // step 4
        return s.toString();
    }

    public static void main(String[] args) {
        String x = "acbcf";
        String y = "abcdaf";
        System.out.println("Longest common subsequence is : " + printingLCS(x, y));
    }
}
