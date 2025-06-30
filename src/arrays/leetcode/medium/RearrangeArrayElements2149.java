package arrays.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArrayElements2149 {


    // Bruteforce better approach
    // works for both variety
    // where it does not matter whether we have number of positive elements are equal to the number of negative elements in the array
    static int[] rearrange(int[]arr){
        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();
        for (int k : arr) {
            if (k >= 0) {
                positive.add(k);
            } else {
                negative.add(k);
            }
        }

        if (positive.size() > negative.size()){
            for (int i=0; i<negative.size(); i++){
                arr[2*i] = positive.get(i);
                arr[2*i+1] = negative.get(i); // odd index stores negative
            }
            // add remaining elements of positive list at the end of the arr without alternative
            int index = negative.size() * 2;
            for (int i=negative.size(); i<positive.size(); i++){
                arr[index] = positive.get(i);
                index++;
            }
        }
        else {
            for (int i=0; i<positive.size(); i++){
                arr[2*i] = positive.get(i);
                arr[2*i+1] = negative.get(i);
            }
            // add remaining elements of negative list at the end of the arr without alternative
            int index = positive.size() * 2;
            for (int i=positive.size(); i<negative.size(); i++){
                arr[index] = negative.get(i);
                index++;
            }
        }
        return arr;
    }

    // Better Approach
    // works only where : number of positive numbers == number of negative numbers
    static int[] rearrange2(int[]arr){
        int n = arr.length;
        int[]result = new int[n];
        int positiveIndex = 0;
        int negativeIndex = 1;
        for (int j : arr) {
            if (j >= 0) {
                result[positiveIndex] = j;
                positiveIndex += 2;
            } else {
                result[negativeIndex] = j;
                negativeIndex += 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[]arr = {3,1,-2,-5,2,-4};
//        System.out.println(Arrays.toString(rearrange(arr)));

        System.out.println(Arrays.toString(rearrange2(arr)));

        arr = new int[]{1,2,-4,-5,3,6};
        System.out.println(Arrays.toString(rearrange(arr)));
    }
}
