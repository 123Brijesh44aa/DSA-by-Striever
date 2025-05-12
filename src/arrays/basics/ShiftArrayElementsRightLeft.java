package arrays.basics;

import java.util.Arrays;

public class ShiftArrayElementsRightsideBy1 {

    static int[] shiftRightside_by_1(int[]arr){
        int temp = arr[arr.length-1];
        for (int i = arr.length - 1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int[]arr = {10,20,30,40,50,60};
        System.out.println(Arrays.toString(shiftRightside_by_1(arr)));
    }
}
