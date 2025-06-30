package arrays.leetcode.easy;

public class UpperBound {

    // upper bound: smallest index such that arr[index] > target


    private static int upperBound(int[]arr, int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid;
        int ans = n;
        while (start <= end){
            mid = start + (end-start)/2;
            if (arr[mid] > target){
                ans = mid;
                // go to the left to find another greater than target element
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {2,3,6,7,8,8,11,11,11,12};
        int target = 10;
        target = 0;
        target = 12;
        target = 40;
        System.out.println(upperBound(arr,target));
    }
}
