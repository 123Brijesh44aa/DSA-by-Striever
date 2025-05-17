package arrays.leetcode.medium;

public class PeakIndexInAMountainArray852 {

    static int peakIndexMountain(int[]arr){
        int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n-1] > arr[n-2]) return (n-1);
        int start = 1;
        int end = n-2;
        int mid = (start+end)/2;
        while (start <= end){
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return  mid;
            }
            if (arr[mid] > arr[mid-1]){
                start = mid + 1;
                mid = (start+end)/2;
            }
            else {
                end = mid - 1;
                mid = (start+end)/2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,8,5,1};
        int peak = peakIndexMountain(arr); // o/p : 7
        if (peak != -1){
            System.err.println("Test Case 1 \nPassed -> Peak is "+peak);
        }
        arr = new int[]{1, 2, 1, 3, 5, 6, 4}; // o/p : 5
        peak = peakIndexMountain(arr);
        if (peak != -1){
            System.err.println("Test Case 2 \nPassed -> Peak is "+peak);
        }
        arr = new int[]{1,2,3,4,5,6};
        peak = peakIndexMountain(arr); // o/p : 5
        if (peak != -1){
            System.err.println("Test Case 3 \nPassed -> Peak is "+peak);
        }
        arr = new int[]{5,4,3,2,1};
        peak = peakIndexMountain(arr); // o/p : 0
        if (peak != -1){
            System.err.println("Test Case 4 \nPassed -> Peak is "+peak);
        }

    }
}
