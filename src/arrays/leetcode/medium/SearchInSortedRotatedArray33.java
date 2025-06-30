package arrays.leetcode.medium;

public class SearchInSortedRotatedArray33 {

    // i/p = 4,5,6,7,0,1,2      target = 0
    // o/p = 4th index

    // approach
    // in graph we have two sorted lines (1 and 2)
    // but how to decide on which line we have to use binary search to find target
    // to decide, first we have to find on which line our target lies
    // if (target >= [pivot] and target <= [n-1] ) { // binary search on line 1 }
    // else { // binary search on line 2 }

    private static int findPivotIndex(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid;
        while (start < end){
            mid = (start+end)/2;
            if (arr[mid] > arr[end]){
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }

    private static int findTargetUsingBinarySearch(int[]arr, int start, int end, int target){
        int mid = (start+end)/2;
        while (start <= end){
            if (target == arr[mid]){
                return mid;
            }
            if (target > arr[mid]){
                // move to the right
                start = mid + 1;
                mid = (start+end)/2;
            }
            if (target < arr[mid]){
                // move to the left
                end = mid - 1;
                mid = (start+end)/2;
            }
        }
        return -1;
    }

    static int search(int[]arr, int target){
        int n = arr.length;
        int pivot = findPivotIndex(arr);
        if (target >= arr[pivot] && target <= arr[n-1]){
            // apply binary search on line 2
            return findTargetUsingBinarySearch(arr,pivot,n-1,target);
        }
        else {
            // apply binary search on line 1
            return findTargetUsingBinarySearch(arr,0,pivot-1,target);
        }
    }

    public static void main(String[] args) {
        int[]arr = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(arr,target));
    }
}
