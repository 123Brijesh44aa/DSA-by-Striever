package arrays.leetcode.medium;

public class NearlySortedArray {

    private static int bs_in_nearlySortedArr(int[]arr, int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid;
        int ans = -1;
        while (start <= end){
            mid = start + (end-start)/2;
            if ((mid-1) >= 0 && arr[mid-1] == target){
                ans = mid-1;
            }
            if (arr[mid] == target){
                ans = mid;
            }
            if ((mid+1) < n && arr[mid+1] == target){
                ans = mid+1;
            }
            if (arr[mid] < target){
                // move to the right
                start = mid + 2;
            }
            else {
                // move to the left
                end = mid - 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {20,10,30,50,40,70,60};
        int target = 60;
        arr = new int[]{0};
        target = 9;
        arr = new int[]{10,20,30,40,50};
        target = 40;
        System.out.println(bs_in_nearlySortedArr(arr,target));
    }
}
