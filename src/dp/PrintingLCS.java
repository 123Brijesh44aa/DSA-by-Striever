package dp;

public class PrintingLCS {

    private static String printingLCS(String x, String y) {

        // Approach :
        // step 1 : create or write lcs program or code
        // fill the dp[][] table
        // step 2 : write code for printing lcs
        // -> if [i][j] are equal then we are moving to [i--][j--] and storing the ith
        // or jth element in the String s;
        // -> if not [i][j] are equal then we are moving to MAX ( [i-1][j], [i][j-1] )
        // step 3 : reverse String s
        // step 4 : return s;

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
                // s = s + x.charAt(i - 1);
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
        // String reversedS = "";
        // for (int k = s.length() - 1; k >= 0; k--) {
        // reversedS += s.charAt(k);
        // }
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
