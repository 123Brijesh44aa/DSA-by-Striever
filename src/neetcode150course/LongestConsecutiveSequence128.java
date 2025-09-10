import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {

    // Given an unsorted array of integers nums, return the length of the longest
    // consecutive elements sequence.

    // You must write an algorithm that runs in O(n) time.

    // Example 1:

    // Input: nums = [100,4,200,1,3,2]
    // Output: 4
    // Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
    // Therefore its length is 4.
    // Example 2:

    // Input: nums = [0,3,7,2,5,8,4,6,0,1]
    // Output: 9
    // Example 3:

    // Input: nums = [1,0,1,2]
    // Output: 3

    private static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int next = num + 1;
                int length = 1;
                while (set.contains(next)) {
                    next = next + 1;
                    length = length + 1;
                    longest = Math.max(longest, length);
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = { 100, 4, 200, 1, 3, 2 };
        System.out.println("longest consecutive sequence is : " + longestConsecutiveSequence(arr));
    }
}