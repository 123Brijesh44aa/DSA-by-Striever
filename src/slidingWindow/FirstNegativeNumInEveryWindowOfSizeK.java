package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FirstNegativeNumInEveryWindowOfSizeK {

    // problem description :
    // Given an array arr[] and a positive integer k, find the first negative
    // integer for each and every window(contiguous subarray) of size k.

    // Note: If a window does not contain a negative integer, then return 0 for that
    // window.

    // Examples:

    // Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
    // Output: [-8, 0, -6, -6]
    // Explanation:
    // Window [-8, 2] First negative integer is -8.
    // Window [2, 3] No negative integers, output is 0.
    // Window [3, -6] First negative integer is -6.
    // Window [-6, 10] First negative integer is -6.
    // Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28] , k = 3
    // Output: [-1, -1, -7, -15, -15, 0]
    // Explanation:
    // Window [12, -1, -7] First negative integer is -1.
    // Window [-1, -7, 8] First negative integer is -1.
    // Window [-7, 8, -15] First negative integer is -7.
    // Window [8, -15, 30] First negative integer is -15.
    // Window [-15, 30, 16] First negative integer is -15.
    // Window [30, 16, 28] No negative integers, output is 0.
    // Input: arr[] = [12, 1, 3, 5] , k = 3
    // Output: [0, 0]
    // Explanation:
    // Window [12, 1, 3] No negative integers, output is 0.
    // Window [1, 3, 5] No negative integers, output is 0.

    // Constraints:
    // 1 <= arr.size() <= 106
    // -105 <= arr[i] <= 105
    // 1 <= k <= arr.size()

    private static int[] firstNegInt(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - (k - 1)];
        for (int i = 0, j = k - 1; i <= n - k; i++, j++) {
            int tempi = i;
            int tempj = j;
            int firstNeg = 0;
            while (tempi <= tempj) {
                if (nums[tempi] < 0) {
                    firstNeg = nums[tempi];
                    break;
                }
                tempi++;
            }
            res[i] = firstNeg;
        }
        return res;
    }

    private static List<Integer> firstNegInt2(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = k - 1; i <= n - k; i++, j++) {
            int tempi = i;
            int tempj = j;
            int firstNeg = 0;
            while (tempi <= tempj) {
                if (nums[tempi] < 0) {
                    firstNeg = nums[tempi]; // take the first negative
                    break; // stop as soon as we find it
                }
                tempi++;
            }
            list.add(firstNeg);
        }
        return list;
    }

    // Space Optimized Approach
    private static List<Integer> firstNegInt_spaceOptimized(int[] arr, int k) {
        int n = arr.length;
        int i = 0; // start of window
        int j = 0; // end of window
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        while (j < n) {
            if (arr[j] < 0) {
                queue.add(j); // storing index of negative element
            }

            if ((j - i + 1) < k) {
                j++; // keep expanding
            } else if ((j - i + 1) == k) { // window formed
                if (!queue.isEmpty()) {
                    result.add(arr[queue.peek()]); // first negative in window
                } else {
                    result.add(0); // no negative in window
                }
                // remove outgoing element if it is the first negative
                if (!queue.isEmpty() && queue.peek() == i) {
                    queue.poll();
                }

                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -8, 2, 3, -6, 10 };
        int k = 2;
        System.out.println("first negative elements are : " + firstNegInt2(nums, k));
    }
}
