package arrays.leetcode.medium;

public class PivotElement153 {

    static int pivotElement(int[]arr){
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
        return arr[start];
    }

    public static void main(String[] args) {
        int[]arr = {6,7,9,1,2,3};
        System.out.println(pivotElement(arr));
        arr = new int[]{3,4,5,1,2};
        System.out.println(pivotElement(arr));
        arr = new int[]{4,5,6,7,0,1,2};
        System.out.println(pivotElement(arr));
        arr = new int[]{11,13,15,17};
        System.out.println(pivotElement(arr));
    }
}
