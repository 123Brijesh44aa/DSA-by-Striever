package dp;

public class MaxLengthOfRepeatedSubArray718 {

    // also known as longest common substring

    // Problem Description:
    // Given two integer arrays nums1 and nums2, return the maximum length of a
    // subarray that appears in both arrays.
    // A subarray is a contiguous sequence of elements within an array.
    //
    // Example:
    // Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
    // Output: 3
    // Explanation: The repeated subarray with maximum length is [3,2,1].
    //
    // Approach:
    // Use dynamic programming to find the longest common subarray (substring)
    // between the two arrays.
    // Create a DP table where dp[i][j] represents the length of the longest common
    // subarray ending at nums1[i-1] and nums2[j-1].
    // If nums1[i-1] == nums2[j-1], then dp[i][j] = dp[i-1][j-1] + 1; otherwise,
    // dp[i][j] = 0.
    // The answer is the maximum value in the DP table.

    private static int maxCommonSubstring(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "abdec";
        System.out.println("longest length of repeated substring is : " + maxCommonSubstring(a, b));
    }
}
