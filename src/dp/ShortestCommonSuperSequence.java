package dp;

public class ShortestCommonSuperSequence {

    // problem description

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
        System.out.println("shortest common super sequence is : "+scs.shortestCommonSupersequence(x, y));
    }
}
