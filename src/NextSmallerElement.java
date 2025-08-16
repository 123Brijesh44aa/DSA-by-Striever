import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    private static int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 5, 2, 25 };
        System.out.println(
                "Next Smaller Element of every element of arr is : " + Arrays.toString(nextSmallerElement(arr)));
    }
}
