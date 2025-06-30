package arrays.basics;

import java.util.Arrays;

public class ReverseArray {

    static int[] reverseArray(int[]arr){ // this function reverses the original array and returns a reversed array.
        for (int i = 0, j = arr.length-1; i < arr.length/2; i++, j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,32,4,6,7,90,67,43,8,9,77};
        int[] arr2 = reverseArray(arr);
        System.out.println(Arrays.toString(arr2));

        System.out.println(Arrays.toString(arr));

    }
}
