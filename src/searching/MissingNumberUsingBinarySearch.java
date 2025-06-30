package searching;

public class MissingNumberUsingBinarySearch {

    // Given a Sorted array with distinct integers in the range (k,n),
    // return the only integer that is missing from the range.
    // Range : e.g. [0,n], [1,n], [2,n], [5,n] etc.

    static int missingNumber(int[]arr){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid = (start+end)/2;
        while (start <= end){
            if (arr[mid] - mid == 0){
                start = mid + 1;
                mid = (start+end)/2;
            }
            else {
                end = mid - 1;
                mid = (start+end)/2;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,6,7};
        System.out.println(missingNumber(arr));
    }
}
