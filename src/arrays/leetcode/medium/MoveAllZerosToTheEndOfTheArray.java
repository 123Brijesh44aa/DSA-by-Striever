package arrays.leetcode.medium;

import java.util.Arrays;

public class MoveAllZerosToTheEndOfTheArray {

    private static int[] moveAllZerosToTheEnd(int[]arr){
        int n = arr.length;
        int position = 0;
        for (int num: arr){
            if (num != 0){
                arr[position] = num;
                position++;
            }
        }
        while (position < n){
            arr[position] = 0;
            position++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[]arr = {1,0,0,2,3,2,0,0,4,5,1};
        System.out.println(Arrays.toString(moveAllZerosToTheEnd(arr)));
        arr = new int[]{0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(moveAllZerosToTheEnd(arr)));
        arr = new int[]{1,0,1,0,1,0,1};
        System.out.println(Arrays.toString(moveAllZerosToTheEnd(arr)));
        arr = new int[]{};
        System.out.println(Arrays.toString(moveAllZerosToTheEnd(arr)));
        arr = new int[]{0,9};
        System.out.println(Arrays.toString(moveAllZerosToTheEnd(arr)));
        arr = new int[]{9};
        System.out.println(Arrays.toString(moveAllZerosToTheEnd(arr)));
        arr = new int[]{-0,-0,-0,0,0,9,8,0,-0};
        System.out.println(Arrays.toString(moveAllZerosToTheEnd(arr)));
    }
}
