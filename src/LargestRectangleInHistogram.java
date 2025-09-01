import java.util.Stack;

/**
 * Finds the area of the largest rectangle that can be formed in a histogram.
 * <p>
 * Problem Description:
 * Given an array of integers representing the heights of bars in a histogram,
 * find the area of the largest rectangle that can be formed within the bounds
 * of the histogram.
 * Each bar has a width of 1 unit.
 * <p>
 * Example:
 * Input: [2, 1, 5, 6, 2, 3]
 * Output: 10
 * Explanation: The largest rectangle has area 10 (formed by heights 5 and 6).
 */

public class LargestRectangleInHistogram {

    private static int[] getNsl(int[] arr) {
        int n = arr.length;
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

    private static int[] getNsr(int[] arr) {
        int n = arr.length;
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

    private static int maxRect(int[] arr) {
        int n = arr.length;
        int[] nsl = getNsl(arr);
        int[] nsr = getNsr(arr);
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] * (nsr[i] - nsl[i] - 1));
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
