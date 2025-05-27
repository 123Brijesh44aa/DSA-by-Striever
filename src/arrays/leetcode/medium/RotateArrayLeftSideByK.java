package arrays.leetcode.medium;

import java.util.Arrays;

public class RotateArrayLeftSideByK {

    private static int[] rotate(int[]arr, int k){
        int n = arr.length;
        int[]temp = new int[n];
        for (int i=0; i<n; i++){
            temp[i] = arr[(i+k)%n];
        }
        System.arraycopy(temp,0,arr,0,n);
        return arr;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(rotate(arr,5)));
    }
}
