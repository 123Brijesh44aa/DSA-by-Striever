package dp;

public class MinNoOfInsAndDel {

    // Problem statement :
    // minimum number of insertion and deletion to convert String a to String b
    // example :
    // a = "heap"
    // b = "pea"
    // o/p => ins=1 , dels=2
    // Explanation :
    // to convert a to be we have to delete 'h' and 'p' from String a and insert 'p'
    // at the beginning to make it String b

    static class Pair {
        int deletions;
        int insertions;

        Pair(int deletions, int insertions) {
            this.deletions = deletions;
            this.insertions = insertions;
        }
    }

    private static Pair minNoOfInsAndDels(String str1, String str2) {
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
        int dels = m - lcs;
        int ins = n - lcs;
        return new Pair(dels, ins);
    }

    public static void main(String[] args) {
        String a = "heap";
        String b = "pea";
        Pair pair = minNoOfInsAndDels(a, b);
        System.out.println("total number of deletions are : " + pair.deletions + "\ntotal number of insertions are : "
                + pair.insertions);
    }
}
