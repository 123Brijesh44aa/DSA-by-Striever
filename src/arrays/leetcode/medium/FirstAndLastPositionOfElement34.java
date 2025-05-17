package arrays.leetcode.medium;

import java.util.Arrays;

public class FirstAndLastPositionOfElement34 {

    static int[] firstAndLastPosition(int[]arr, int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid = (start+end)/2;
        int firstIndex = -1;
        int lastIndex = -1;

        while (start <= end){
            if (target == arr[mid]) {
                firstIndex = mid;
                end = mid - 1;
                mid = (start+end)/2;
            }
            if (target > arr[mid]){ // move right side
                start = mid + 1;
                mid = (start+end)/2;
            }
            if (target < arr[mid]){ // move left side
                end = mid - 1;
                mid = (start+end)/2;
            }
        }

        // reset start and end
        start = 0;
        end = n-1;
        while (start <= end){
            if (target == arr[mid]){
                lastIndex = mid;
                start = mid + 1;
                mid = (start+end)/2;
            }
            if (target > arr[mid]){
                start = mid + 1;
                mid = (start+end)/2;
            }
            if (target < arr[mid]){
                end = mid - 1;
                mid = (start+end)/2;
            }
        }
        return new int[]{firstIndex,lastIndex};
    }

    public static void main(String[] args) {
        int[]arr = { 5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(firstAndLastPosition(arr,target)));
        arr = new int[]{5,7,7,8,8,10};
        target = 6;
        System.out.println(Arrays.toString(firstAndLastPosition(arr,target)));
        arr = new int[]{};
        target = 0;
        System.out.println(Arrays.toString(firstAndLastPosition(arr,target)));;
        arr = new int[]{90};
        target = 5;
        System.out.println(Arrays.toString(firstAndLastPosition(arr,target)));
        target = 90;
        System.out.println(Arrays.toString(firstAndLastPosition(arr,target)));
    }
}
