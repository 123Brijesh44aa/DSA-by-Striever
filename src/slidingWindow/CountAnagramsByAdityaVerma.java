package slidingWindow;

import java.util.Arrays;

public class CountAnagramsByAdityaVerma {

    // problem description :
    // given a String and a pattern string
    // return total number of count of anagrams of pattern present in given String

    // example:
    // input = "aabaabaa", pattern = "aaba"
    // output : 4
    // explanation :
    // 1st anagram in window 1 = aaba
    // 2nd anagram in window 2 = abaa
    // 3rd anagram in window 4 = aaba
    // 4th anagram in window 5 = abaa
    // hence total count = 4

    private static int countAnagrams(String string, String pattern) {
        int n = string.length();
        int k = pattern.length(); // window size
        int count = 0;

        // count frequency of pattern String
        int[] patternFreq = new int[26];
        for (int p = 0; p < k; p++) {
            patternFreq[pattern.charAt(p) - 'a']++;
        }

        // count frequency of first window
        int[] windowFreq = new int[26];
        for (int w = 0; w < k; w++) {
            windowFreq[string.charAt(w) - 'a']++;
        }

        // compare patternFreq and patternFreq
        if (Arrays.equals(patternFreq, windowFreq)) {
            count++;
        }

        for (int i = 1; i <= n - k; i++) {
            // remove freq of outgoing char
            windowFreq[string.charAt(i - 1) - 'a']--;
            // add freq of incoming char
            windowFreq[string.charAt(i + k - 1) - 'a']++;

            if (Arrays.equals(patternFreq, windowFreq)) {
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        // String a = "brijesh";
        // String b = "rbjishe";
        // System.out.println("is valid anagram : " + isValidAnagram(a, b));

        String s = "forxxorfxdofr";
        String p = "for";

        System.out.println("total count of anagrams : " + countAnagrams(s, p));
    }
}