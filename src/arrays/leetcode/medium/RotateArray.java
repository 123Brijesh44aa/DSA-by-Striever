package arrays.leetcode.medium;

import java.util.Arrays;

public class RotateArray {

    static int[] rotate(int[]arr, int k){
        int n = arr.length;
        int[]temp = new int[n];
        for (int index=0; index<n; index++){
            temp[(index+k)%n] = arr[index];
        }
        System.arraycopy(temp, 0, arr, 0, n);
        return arr;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6};
        int k = 3;
        System.out.println(Arrays.toString(rotate(arr,k)));
    }
}
