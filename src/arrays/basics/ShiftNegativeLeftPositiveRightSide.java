package arrays.basics;

import java.util.Arrays;

public class ShiftNegativeLeftPositiveRightSide {

    static int[] shiftNegativeLeftPositiveRight(int[]arr){
        int j = 0;
        for (int index = 0; index<arr.length; index++){
           if (arr[index] < 0){
               int temp = arr[index];
               arr[index] = arr[j];
               arr[j] = temp;
               j++;
           }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[]arr = {0,23,-7,12,-10,-1,40,60,-89,-0};
        System.out.println(Arrays.toString(shiftNegativeLeftPositiveRight(arr)));
    }
}
