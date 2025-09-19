package oopslab;

import java.util.Arrays;

public class Reverse {
    private static int[] reverse(int[] arr) {
        int n = arr.length;
        if (arr == null || n == 0) {
            return new int[] {};
        }
        int[] res = new int[n];
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            res[i] = arr[j];
        }
        return res;
    }

    // optimal approach ( in place )
    private static int[] reverse_optimal(int[] arr) {
        int n = arr.length;
        if (arr == null || n == 0) {
            return new int[] {};
        }
        int i = 0;
        int j = n - 1;
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
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("reverse array is : " + Arrays.toString(reverse_optimal(arr)));
    }
}
