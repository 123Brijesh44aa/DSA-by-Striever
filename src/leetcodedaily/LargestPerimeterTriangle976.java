package leetcodedaily;

import java.util.Arrays;

public class LargestPerimeterTriangle976 {

    // problem description 
    // Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
// Example 1:
// Input: nums = [2,1,2]
// Output: 5
// Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
// Example 2:
// Input: nums = [1,2,1,10]
// Output: 0
// Explanation: 
// You cannot use the side lengths 1, 1, and 2 to form a triangle.
// You cannot use the side lengths 1, 1, and 10 to form a triangle.
// You cannot use the side lengths 1, 2, and 10 to form a triangle.
// As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
    private static int largestPerimeter(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = n - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1] + arr[i - 2]) {
                return arr[i] + arr[i - 1] + arr[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 2};
        System.out.println("largest Perimeter is : " + largestPerimeter(arr));
    }
}
