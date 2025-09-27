package slidingWindow;

public class CountAnagrams2514 {

    // problem description :
    // You are given a string s containing one or more words. Every consecutive pair
    // of words is separated by a single space ' '.

    // A string t is an anagram of string s if the ith word of t is a permutation of
    // the ith word of s.

    // For example, "acb dfe" is an anagram of "abc def", but "def cab" and "adc
    // bef" are not.
    // Return the number of distinct anagrams of s. Since the answer may be very
    // large, return it modulo 109 + 7.

    // Example 1:

    // Input: s = "too hot"
    // Output: 18
    // Explanation: Some of the anagrams of the given string are "too hot", "oot
    // hot", "oto toh", "too toh", and "too oht".
    // Example 2:

    // Input: s = "aa"
    // Output: 1
    // Explanation: There is only one anagram possible for the given string.

    // Constraints:

    // 1 <= s.length <= 105
    // s consists of lowercase English letters and spaces ' '.
    // There is single space between consecutive words.

    private static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private static int countAnagrams(String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        String[] stringArr = string.split(" ");
        int result = 1;
        for (String s : stringArr) {
            int[] charFreq = new int[26];
            int divider = 1;
            for (int j = 0; j < s.length(); j++) {
                charFreq[s.charAt(j) - 'a']++;
                for (int k = 0; k < 26; k++) {
                    if (charFreq[k] == 0 || charFreq[k] == 1) {
                        continue;
                    } else {
                        divider *= fact(charFreq[k]);
                    }
                }
            }
            result *= fact(s.length()) / divider;
        }

        return result;

    }

    public static void main(String[] args) {
        String s = "too hot";
        s = "aa";
        System.out.println("total anagrams : " + countAnagrams(s));
    }
}
