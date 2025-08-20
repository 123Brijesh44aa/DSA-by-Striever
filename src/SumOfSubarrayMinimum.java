import java.util.Stack;

public class SumOfSubarrayMinimum {

    // Given an array of integers arr, find the sum of min(b), where b ranges over
    // every (contiguous) subarray of arr. Since the answer may be large, return the
    // answer modulo 109 + 7.

    // Example 1:

    // Input: arr = [3,1,2,4]
    // Output: 17
    // Explanation:
    // Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4],
    // [3,1,2,4].
    // Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
    // Sum is 17.
    // Example 2:

    // Input: arr = [11,81,94,43,3]
    // Output: 444

    // Constraints:

    // 1 <= arr.length <= 3 * 104
    // 1 <= arr[i] <= 3 * 104

    private static int sumOfSubArrayMins(int[] arr) {
        int n = arr.length;
        int[] nsl = getNSL(arr, n);
        int[] nsr = getNSR(arr, n);
        long sum = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            int leftDistance = i - nsl[i];
            int rightDistance = nsr[i] - i;

            // total ways
            long totalWays = leftDistance * rightDistance;

            // contribution of one element
            long contribution = totalWays * arr[i];

            // total sum of all the contributions
            sum = (sum + contribution) % mod;
        }
        return (int) sum;
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

    // Edge case: duplicate elements in the array
    // How to resolve this:
    // The code already handles duplicate elements correctly by using '>=' in getNSL
    // and '>' in getNSR.
    // This ensures that for duplicates, the left boundary is exclusive (previous
    // less) and the right boundary is inclusive (next less).

    public static void main(String[] args) {

    }
}
