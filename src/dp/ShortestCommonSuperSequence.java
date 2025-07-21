package dp;

public class ShortestCommonSuperSequence {

    // Shortest Common Supersequence (SCS) Problem

    // Problem Description

    // The Shortest Common Supersequence (SCS) problem aims to find the shortest
    // possible string that contains two given strings as subsequences. A
    // subsequence is formed by deleting zero or more characters from a string
    // without changing the order of the remaining characters.

    // In essence, given str1 and str2, we seek the shortest string S such that both
    // str1 and str2 can be obtained from S by deleting some characters.

    // Key Concepts:

    // Subsequence: Characters in order, but not necessarily contiguous (e.g., ACE
    // is a subsequence of ABCDE).
    // Supersequence: A string containing another as a subsequence (e.g., ABCDE is a
    // supersequence of ACE).
    // Shortest Common Supersequence: The shortest string that is a supersequence of
    // both given strings.

    // Example:

    // Let str1 = AGGTAB and str2 = GXTXAYB.

    // The Shortest Common Supersequence (SCS) is AGXGTXAYB.

    // Verification:
    // AGGTAB is a subsequence of AGXGTXAYB (AGXGTXAYB).
    // GXTXAYB is a subsequence of AGXGTXAYB (AGXGTXAYB).

    // Length Calculation:
    // The length of the SCS can be found using the formula:
    // Length(SCS) = Length(str1) + Length(str2) - Length(LCS)

    // Where LCS is the Longest Common Subsequence. For our example, LCS(AGGTAB,
    // GXTXAYB) is GTAB, with a length of 4.

    // So, Length(SCS) = 6 + 7 - 4 = 9.
    // The SCS AGXGTXAYB has a length of 9.

    public int shortestCommonSupersequence(String str1, String str2) { // npm install -g @anthropic-ai/claude-code
        // Step 1 -> find the LCS
        // final Step -> return (str1.length + str2.length - LCS)

        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int lcs = dp[m][n];

        return (m + n - lcs);
    }

    public static void main(String[] args) {
        ShortestCommonSuperSequence scs = new ShortestCommonSuperSequence();
        String x = "AGGTAB";
        String y = "GXTXAYB";
        System.out.println("shortest common super sequence is : " + scs.shortestCommonSupersequence(x, y));
    }
}
