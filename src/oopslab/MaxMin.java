package oopslab;

import java.util.Arrays;

public class MaxMin {
    private static int[] minMax(int[] arr) {
        int n = arr.length;
        if (arr == null || n == 0) {
            return new int[] {};
        }
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        res[0] = min;
        res[1] = max;

        return res;

    }

    public static void main(String[] args) {
        int[] arr = { -9, 4, -2, -99, -3, 0, 0, -2, 3, 1 };
        System.out.println("min and max : " + Arrays.toString(minMax(arr)));
    }
}
