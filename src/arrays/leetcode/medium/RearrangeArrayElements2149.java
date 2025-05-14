package arrays.leetcode.medium;

import java.util.Arrays;

public class RearrangeArrayElements2149 {

    static int[] rearrange(int[]arr){
        int n = arr.length;
        int[] negative = new int[n/2];
        int[] positive = new int[n/2];
        int positiveIndex = 0;
        int negativeIndex = 0;
        for (int i=0; i<n; i++){
            if (arr[i] >= 0) {
                positive[positiveIndex++] = arr[i];
            }
            else {
                negative[negativeIndex++] = arr[i];
            }
        }

        // Reset positiveIndex and negativeIndex = 0, because right now they are n/2 and n/2
        positiveIndex = 0;
        negativeIndex = 0;
        for (int j=0; j<n; j++){
            if ( (j % 2) == 0){
                arr[j] = positive[positiveIndex++];
            }
            else {
                arr[j] = negative[negativeIndex++];
            }
        }
        return arr;
    }

    // Better Approach
    static int[] rearrange2(int[]arr){
        int n = arr.length;
        int[]result = new int[n];
        int positiveIndex = 0;
        int negativeIndex = 1;
        for (int i=0; i<n; i++){
            if (arr[i] >= 0){
                result[positiveIndex] = arr[i];
                positiveIndex += 2;
            }
            else {
                result[negativeIndex] = arr[i];
                negativeIndex += 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[]arr = {3,1,-2,-5,2,-4};
//        System.out.println(Arrays.toString(rearrange(arr)));

        System.out.println(Arrays.toString(rearrange2(arr)));
    }
}
