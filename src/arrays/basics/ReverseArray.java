package arrays.basics;

import java.util.Arrays;

public class ReverseArray {

    static int[] reverseArray(int[]arr){
        int j = arr.length-1;
        for (int i = 0; i < arr.length/2; i++){
            int temp;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,32,4,6,7,90,67,43,8,9};
        int[] arr2 = reverseArray(arr);
        System.out.println(Arrays.toString(arr2));

    }
}
