package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString438 {
    // problem description
    // Given two strings s and p, return an array of all the start indices of p's
    // anagrams in s. You may return the answer in any order.

    // Example 1:

    // Input: s = "cbaebabacd", p = "abc"
    // Output: [0,6]
    // Explanation:
    // The substring with start index = 0 is "cba", which is an anagram of "abc".
    // The substring with start index = 6 is "bac", which is an anagram of "abc".
    // Example 2:

    // Input: s = "abab", p = "ab"
    // Output: [0,1,2]
    // Explanation:
    // The substring with start index = 0 is "ab", which is an anagram of "ab".
    // The substring with start index = 1 is "ba", which is an anagram of "ab".
    // The substring with start index = 2 is "ab", which is an anagram of "ab".

    // Constraints:

    // 1 <= s.length, p.length <= 3 * 104
    // s and p consist of lowercase English letters.

    // BRUTE FORCE APPROACH
    private static boolean isValidAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] anagrams = new int[26];
        for (int i = 0; i < a.length(); i++) {
            anagrams[a.charAt(i) - 'a']++;
            anagrams[b.charAt(i) - 'a']--;
        }
        for (int i : anagrams) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if ((j - i + 1) == p.length()) {
                if (isValidAnagram(p, s.substring(i, j + 1))) {
                    list.add(i);
                }
                i++;
            }
            j++;
        }

        return list;
    }

    // optimal approach

    private static List<Integer> findAnagrams_optimal(String s, String p) {
        int n = s.length();
        int k = p.length();
        List<Integer> list = new ArrayList<>();

        if (k > n) {
            return list;
        }

        // count the freq of chars of String p
        int[] pf = new int[26];
        for (int i = 0; i < k; i++) {
            pf[p.charAt(i) - 'a']++;
        }

        // count the freq of first window
        int[] wf = new int[26];
        for (int i = 0; i < k; i++) {
            wf[s.charAt(i) - 'a']++;
        }

        // compare pf and wf
        if (Arrays.equals(pf, wf)) {
            list.add(0);
        }

        for (int i = 1; i <= n - k; i++) {
            // remove freq of outgoing char
            wf[s.charAt(i - 1) - 'a']--;
            // add freq of incoming char
            wf[s.charAt(i + k - 1) - 'a']++;

            if (Arrays.equals(pf, wf)) {
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {

    }
}
