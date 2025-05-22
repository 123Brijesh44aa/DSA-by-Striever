package arrays.leetcode.easy;

public class FloorAndCeil {

    // Floor function : [3.4] -> 3 , [-2.9] -> -3  ( arr[index] == x OR arr[index] < x)
    // Ceil function : [4.9] -> 5 , [-8.3] -> -7   ( arr[index] == x OR arr[index] > x)

    private static int floor(int[]arr, int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid;
        int ans = -1;
        while (start <= end){
            mid = start + (end-start)/2;
            if (arr[mid] <= target){
                // go to the right because we might find an element which is equal or less than target
                ans = mid;
                start = mid + 1;
            }
            else {
                // go to the right
                end = mid - 1;
            }
        }
        return ans;
    }

    private static int ceil(int[]arr, int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid;
        int ans = -1;
        while (start <= end){
            mid = start + (end-start)/2;
            if (arr[mid] >= target){
                ans = mid;
                // to the left
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {10,20,30,40,50};
        int target = 25;
        arr = new int[]{10,20,30,40,50,60,70};
        target = 55;
        System.out.println(arr[floor(arr,target)]);
        System.out.println(arr[ceil(arr,target)]);
    }
}
