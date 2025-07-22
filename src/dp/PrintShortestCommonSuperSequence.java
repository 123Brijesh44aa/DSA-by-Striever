package dp;

public class PrintShortestCommonSuperSequence {

    // problem Statement :
    // print shortest common super sequence

    // APPROACH:
    // 1. Build the LCS DP Table
    // First, fill a dynamic programming (DP) table (let's call it dp) for the
    // Longest Common Subsequence (LCS) of your two input strings, say str1 and
    // str2. This table will store the lengths of LCS for all prefixes of str1 and
    // str2.

    // 2. Backtrack and Reconstruct the SCS
    // Start at the bottom-right corner of your dp table. Use two pointers, one for
    // each string, and move diagonally up-left, or straight up or left, based on
    // the dp values:

    // If str1's character matches str2's character: This character is part of the
    // LCS. Add it once to your result and move both pointers diagonally up-left.

    // If characters don't match: Look at dp[i-1][j] (skipping str1's current char)
    // and dp[i][j-1] (skipping str2's current char).

    // If dp[i-1][j] is greater, it means str1's character was likely not part of
    // the common subsequence in that path. Add str1's character to your result and
    // move its pointer up.

    // Otherwise (if dp[i][j-1] is greater or equal), add str2's character to your
    // result and move its pointer left.

    // Crucially, when characters don't match, you must include both unmatched
    // characters in the SCS, one at a time, based on which path in the DP table
    // leads to the "LCS" by removing the other.

    // 3. Append Remaining Characters
    // After backtracking, if either string still has remaining characters (because
    // one pointer reached the start before the other), append all those remaining
    // characters to your SCS result.

    // Remember to build the SCS by prepending characters as you backtrack, or
    // reverse the final string if you append them.

    private static String printSCS(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int i = n;
        int j = m;
        StringBuilder ans = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    ans.append(str1.charAt(i - 1));
                    i--;
                } else {
                    ans.append(str2.charAt(j - 1));
                    j--;
                }
            }
        }

        while (i > 0) {
            ans.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            ans.append(str2.charAt(j - 1));
            j--;
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";
        System.out.println("the shortest common super sequence is : " + printSCS(x, y));
    }
}
