package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxSumOfDistinctSubarraysWithLengthK2461 {

    // problem description :

    // You are given an integer array nums and an integer k. Find the maximum
    // subarray sum of all the subarrays of nums that meet the following conditions:

    // The length of the subarray is k, and
    // All the elements of the subarray are distinct.
    // Return the maximum subarray sum of all the subarrays that meet the
    // conditions. If no subarray meets the conditions, return 0.

    // A subarray is a contiguous non-empty sequence of elements within an array.

    // Example 1:

    // Input: nums = [1,5,4,2,9,9,9], k = 3
    // Output: 15
    // Explanation: The subarrays of nums with length 3 are:
    // - [1,5,4] which meets the requirements and has a sum of 10.
    // - [5,4,2] which meets the requirements and has a sum of 11.
    // - [4,2,9] which meets the requirements and has a sum of 15.
    // - [2,9,9] which does not meet the requirements because the element 9 is
    // repeated.
    // - [9,9,9] which does not meet the requirements because the element 9 is
    // repeated.
    // We return 15 because it is the maximum subarray sum of all the subarrays that
    // meet the conditions
    // Example 2:

    // Input: nums = [4,4,4], k = 3
    // Output: 0
    // Explanation: The subarrays of nums with length 3 are:
    // - [4,4,4] which does not meet the requirements because the element 4 is
    // repeated.
    // We return 0 because no subarrays meet the conditions.

    private static long maxSumOfDistinctSubarraysWithLengthK2461(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        long maxSum = 0L;
        long currSum = 0L;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            if (i >= k - 1) {
                if (freqMap.size() == k) {
                    maxSum = Math.max(maxSum, currSum);
                }
                currSum = currSum - nums[i - k + 1];
                freqMap.put(nums[i - k + 1], freqMap.get(nums[i - k + 1]) - 1);
                if (freqMap.get(nums[i - k + 1]) == 0) {
                    freqMap.remove(nums[i - k + 1]);
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {

    }
}
