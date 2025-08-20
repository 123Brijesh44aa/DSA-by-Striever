import java.util.Stack;

/**
 * SumOfSubarrayRanges
 *
 * Problem Description:
 * Given an integer array nums, the range of a subarray is the difference
 * between the largest and smallest element in the subarray.
 * Return the sum of all subarray ranges of nums.
 *
 * Input:
 * - An integer array nums of length n (1 <= n <= 1000, -10^9 <= nums[i] <=
 * 10^9).
 *
 * Output:
 * - An integer representing the sum of the ranges of all possible subarrays of
 * nums.
 *
 * Explanation:
 * - For each possible subarray of nums, calculate the difference between the
 * maximum and minimum element in that subarray.
 * - Sum up these differences for all subarrays and return the result.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output: 4
 * Explanation:
 * - The subarrays of nums are: [1], [2], [3], [1,2], [2,3], [1,2,3]
 * - Their ranges are: 0, 0, 0, 1, 1, 2
 * - The sum of these ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4
 */
public class SumOfSubarrayRanges {

    private static long sumOfSubarrayRanges(int[] arr) {
        long sumOfSubarryMax = sumOfSubarrayMax(arr);
        long sumOfSubarrayMin = sumOfSubArrayMin(arr);
        return (sumOfSubarryMax - sumOfSubarrayMin);
    }

    private static long sumOfSubArrayMin(int[] arr) {
        int n = arr.length;
        int[] nsl = getNSL(arr, n);
        int[] nsr = getNSR(arr, n);
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int leftDistance = i - nsl[i];
            int rightDistance = nsr[i] - i;

            // total ways
            long totalWays = leftDistance * rightDistance;

            // contribution of one element
            long contribution = totalWays * arr[i];

            // total sum of all the contributions
            sum = (sum + contribution);
        }
        return sum;
    }

    private static int[] getNSL(int[] arr, int n) {
        int[] nsl = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stack.peek();
            }

            stack.push(i);
        }
        return nsl;
    }

    private static int[] getNSR(int[] arr, int n) {
        int[] nsr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = stack.peek();
            }

            stack.push(i);
        }
        return nsr;
    }

    private static long sumOfSubarrayMax(int[] arr) {
        int n = arr.length;
        int[] ngl = getNGL(arr, n);
        int[] ngr = getNGR(arr, n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int leftDistance = i - ngl[i];
            int rightDistance = ngr[i] - i;
            // find total ways
            long totalWays = leftDistance * rightDistance;
            // find contribution of one element
            long contribution = totalWays * arr[i];
            // total sum of all the contributions
            sum = (sum + contribution);
        }
        return sum;
    }

    private static int[] getNGL(int[] arr, int n) {
        int[] ngl = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ngl[i] = -1;
            } else {
                ngl[i] = stack.peek();
            }
            stack.push(i);
        }
        return ngl;
    }

    private static int[] getNGR(int[] arr, int n) {
        int[] ngr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ngr[i] = n;
            } else {
                ngr[i] = stack.peek();
            }
            stack.push(i);
        }
        return ngr;
    }

    public static void main(String[] args) {

    }
}
