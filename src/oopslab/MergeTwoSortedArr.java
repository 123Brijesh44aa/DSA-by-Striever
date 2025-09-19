package oopslab;

import java.util.Arrays;

public class MergeTwoSortedArr {
    private static int[] mergeTwoSortedArr(int[] a, int[] b) {
        if (a == null || a.length == 0) {
            return b;
        }
        if (b == null || b.length == 0) {
            return a;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[a.length + b.length];
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }

        while (i < a.length) {
            res[k++] = a[i++];
        }

        while (j < b.length) {
            res[k++] = b[j++];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 6, 7, 8, 9, 10 };
        System.out.println("single sorted array is : " + Arrays.toString(mergeTwoSortedArr(a, b)));
    }
}
