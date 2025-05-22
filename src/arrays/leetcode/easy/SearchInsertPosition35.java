package arrays.leetcode.easy;

public class SearchInsertPosition35 {

/*

PROBLEM DESCRIPTION :

    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
*/

    private static int searchInsert(int[]arr, int target){
        // this problem is the same as finding the lower bound.
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid;
        int ans = n;
        while (start <= end){
            mid = start + (end-start)/2;
            if (arr[mid] >= target){
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {1,3,5,6};
        int target = 4;
        System.out.println(searchInsert(arr,target));
    }
}
