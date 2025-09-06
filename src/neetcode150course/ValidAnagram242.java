package neetcode150course;

import java.util.HashMap;

public class ValidAnagram242 {

    // problem description
    // Given two strings s and t, return true if t is an anagram of s, and false
    // otherwise.

    // Example 1:

    // Input: s = "anagram", t = "nagaram"

    // Output: true

    // Example 2:

    // Input: s = "rat", t = "car"

    // Output: false

    // optimal approach
    private static boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
            alphabets[t.charAt(i) - 'a']--;
        }
        for (int i : alphabets) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
