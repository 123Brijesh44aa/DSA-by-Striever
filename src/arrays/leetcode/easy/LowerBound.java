package arrays.leetcode.easy;

public class LowerBound {

    // Lower Bound: smallest index such that arr[index] >= target;

    private static int lowerBound(int[]arr, int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid = start + (end-start)/2;
        int ans = n;
        while (start <= end){
            if (arr[mid] >= target){
                ans = mid;
                // look for smaller index on a left
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            mid = start + (end-start)/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {1,1,2,3,4,5,8,10,23};
        int target = 9;
        System.out.println(lowerBound(arr,target));
    }
}
