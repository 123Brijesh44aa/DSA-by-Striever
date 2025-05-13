package arrays.leetcode.medium;

import java.util.Arrays;

public class SortColors {

    static void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sortColors(int[]nums){
        int n = nums.length;
        int index = 0;
        int left = 0;
        int right = n-1;
        for (int i=0; index <= right; i++){
            if (nums[index] == 0){
               swap(nums,index,left);
               index++;
               left++;
            }
            else if (nums[index] == 2){
                swap(nums,index,right);
                right--;
                // catch -> no need to index plus (index++)
            }
            else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[]arr = {0,1,2,0,1,0,1,2,0,1,1,1,1,2,2,2};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
