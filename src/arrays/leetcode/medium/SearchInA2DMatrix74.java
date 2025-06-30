package arrays.leetcode.medium;

public class SearchInA2DMatrix74 {

    private static boolean search(int[][]arr, int target){
        int n = arr.length;
        int m = arr[0].length;
        int start = 0;
        int end = n*m - 1;
        int mid;
        while (start <= end){
            mid = start + (end-start)/2;
            int row = mid/m;
            int col = mid%m;
            if (arr[row][col] == target) return true;
            else if (arr[row][col] < target){
                // move to the right
                start = mid + 1;
            }
            else {
                // move to the left
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][]arr = {
                {3,4,7,9},
                {12,13,16,18},
                {20,21,23,29},
        };
        int target = 23;
        boolean isFound = search(arr,target);
        System.out.println(isFound);
    }
}
