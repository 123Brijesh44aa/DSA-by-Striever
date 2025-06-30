package searching;

public class BinarySearch {

    static int binarySearch(int[]arr, int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid = (start+end)/2;
        for (int i=0; i<n/2; i++){
            if (target == arr[mid]){
                return mid;
            }
            if (target < arr[mid]){
                end = mid - 1;
                mid = (start+end)/2;
            }
            if (target > arr[mid]){
                start = mid + 1;
                mid = (start+end)/2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,8};
        int target = 8;
        System.out.println(binarySearch(arr,target));
    }
}
