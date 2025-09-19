package oopslab;

import java.util.Arrays;

public class RotateRightByK {

    // private static int[] rotate(int[] arr, int k) {
    // int n = arr.length;
    // if (arr == null || n == 0) {
    // return new int[] {};
    // }
    // int[] res = new int[n];
    // for (int i = 0; i < n; i++) {
    // res[(i + k) % n] = arr[i];
    // }
    // return res;
    // }

    // optimal ( in place ) approach
    private static int[] rotate_optimal(int[] arr, int k) {
        int n = arr.length;
        if (arr == null || n == 0) {
            return new int[] {};
        }
        // reverse array
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        // reverse 0 to k and then k to n
        i = 0;
        j = k - 1; // or j = k-1
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        // reverse k to n elements
        i = k;
        j = n - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return arr;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("rotated arr is : " + Arrays.toString(rotate_optimal(arr, 2)));
    }
}
