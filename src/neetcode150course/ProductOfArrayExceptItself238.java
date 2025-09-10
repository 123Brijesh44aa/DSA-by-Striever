
import java.util.Arrays;

public class ProductOfArrayExceptItself238 {

    // Problem Description :
    // Given an integer array nums, return an array answer such that answer[i] is
    // equal to the product of all the elements of nums except nums[i].

    // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
    // integer.

    // You must write an algorithm that runs in O(n) time and without using the
    // division operation.

    // Example 1:

    // Input: nums = [1,2,3,4]
    // Output: [24,12,8,6]
    // Example 2:

    // Input: nums = [-1,1,0,-3,3]
    // Output: [0,0,9,0,0]

    private static int[] prefixProduct(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        return res;
    }

    private static int[] postfixProduct(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            res[i] = res[i + 1] * nums[i + 1];
        }
        return res;
    }

    private static int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[] {};
        }

        int[] result = new int[nums.length];
        int[] pre = prefixProduct(nums);
        int[] post = postfixProduct(nums);

        for (int i = 0; i < nums.length; i++) {
            result[i] = pre[i] * post[i];
        }

        return result;

    }

    // Space Optimized Approach
    private static int[] productExceptSelf_optimizedSpace(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new int[] {};
        }

        int[] res = new int[n];
        int pre = 1;
        // calculate prefix product
        for (int i = 0; i < n; i++) {
            res[i] = pre;
            pre = pre * nums[i];
        }

        // multiply postfix products on the way
        int post = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * post;
            post = post * nums[i];
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = { -1, 1, 0, -3, 3 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        nums = new int[] { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }
}
