import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {

    // problem description :
    // Given a string s, find the length of the longest substring without duplicate
    // characters.

    // Example 1:

    // Input: s = "abcabcbb"
    // Output: 3
    // Explanation: The answer is "abc", with the length of 3.
    // Example 2:

    // Input: s = "bbbbb"
    // Output: 1
    // Explanation: The answer is "b", with the length of 1.
    // Example 3:

    // Input: s = "pwwkew"
    // Output: 3
    // Explanation: The answer is "wke", with the length of 3.
    // Notice that the answer must be a substring, "pwke" is a subsequence and not a
    // substring.

    // Optimal Approach
    private static int longestSubstring(String s) {
        int i = 0;
        int ans = 0;
        int n = s.length();
        int j;
        int[] count = new int[256];
        for (j = 0; j < n; j++) {
            char c = s.charAt(j);
            count[c]++;

            while (count[c] > 1) {
                count[s.charAt(i)]--;
                i++;
            }

            ans = Math.max(ans, (j - i + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("longest substring is : " + longestSubstring(s));
    }
}
