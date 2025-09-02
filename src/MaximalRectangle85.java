import java.util.Stack;

public class MaximalRectangle85 {

    public int[] pse(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        return pse;
    }

    public int[] nse(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        return nse;
    }

    public int maxRectHistogram(int[] arr) {
        int n = arr.length;
        int maxRect = 0;
        int[] nse = nse(arr);
        int[] pse = pse(arr);
        for (int i = 0; i < n; i++) {
            maxRect = Math.max(maxRect, arr[i] * (nse[i] - pse[i] - 1));
        }
        return maxRect;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maximalRect = 0;
        int[][] prefixSum = new int[n][m];
        // calculate prefixSum
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] == '0') {
                    sum = 0;
                } else {
                    sum = sum + 1;
                }
                prefixSum[j][i] = sum;
            }
        }

        for (int[] row : prefixSum) {
            maximalRect = Math.max(maximalRect, maxRectHistogram(row));
        }

        return maximalRect;
    }

    public static void main(String[] args) {

    }
}
