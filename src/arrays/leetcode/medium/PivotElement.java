package arrays.leetcode.medium;

public class PivotElement {

    static int pivotElement(int[]arr){
        int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] < arr[1]) return 0;
        if (arr[n-1] < arr[n-2]) return (n-1);
        int start = 1;
        int end = n-2;
        int mid = (start+end)/2;
        while (start <= end){
            if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]){
                return mid;
            }
            if (arr[mid] > arr[mid-1]){
                start = mid + 1;
                mid = (start+end)/2;
            }
            if (arr[mid] > arr[mid+1]){
                end = mid - 1;
                mid = (start+end)/2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]arr = {6,7,9,1,2,3};
        System.out.println(pivotElement(arr));
    }
}
