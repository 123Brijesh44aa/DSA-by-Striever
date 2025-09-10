
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {

    // Given an array of strings strs, group the anagrams together. You can return
    // the answer in any order.

    // Example 1:

    // Input: strs = ["eat","tea","tan","ate","nat","bat"]

    // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    // Explanation:

    // There is no string in strs that can be rearranged to form "bat".
    // The strings "nat" and "tan" are anagrams as they can be rearranged to form
    // each other.
    // The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to
    // form each other.
    // Example 2:

    // Input: strs = [""]

    // Output: [[""]]

    // Example 3:

    // Input: strs = ["a"]

    // Output: [["a"]]

    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        int[] frequency = new int[26];

        for (String s : strs) {
            Arrays.fill(frequency, 0);
            // store and increment the frequency of each character of each word
            for (char c : s.toCharArray()) {
                frequency[c - 'a']++;
            }

            // create key
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(frequency[i]);
            }

            String key = sb.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

    }
}
