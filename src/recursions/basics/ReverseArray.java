package recursions.basics;

import java.util.Arrays;

public class ReverseArray {

    // reverse array using two pointers
    void reverse(int start, int end, int[] arr){
        if (start >= end){
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverse(start+1, end-1, arr);
    }
    void reverseArray(int[] arr){
        reverse(0, arr.length - 1, arr);
    }

    // Reverse Array using a single pointer
    void reverse2(int start, int[] arr){
        if (start >= (arr.length)/2 ){
            return;
        }
        int temp = arr[start];
        arr[start] = arr[(arr.length) - start - 1];
        arr[(arr.length) - start - 1] = temp;

        reverse2(start+1, arr);
    }
    void reverseArray2(int[]arr){
        reverse2(0, arr);
    }

    public static void main(String[] args) {
        ReverseArray ra = new ReverseArray();
        int[] arr = {1,2,3,4,5,6};
        ra.reverseArray(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {9,8,7,6,5,4};
        ra.reverseArray2(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
