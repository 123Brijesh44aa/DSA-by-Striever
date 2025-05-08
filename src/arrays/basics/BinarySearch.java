package arrays.basics;

public class BinarySearch {

    // using loop
    static int binarySearch(int[]arr, int low, int high, int key){
        while (low<=high){
            int mid = (int) Math.floor((double) (low + high) /2);
            if (key == arr[mid]){
                return mid;
            }
            else {
                if (key < arr[mid]){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    // using recursion
    static int binarySearch_r(int[]arr, int low, int high, int key){
        if (low<=high){
            int mid = (int) Math.floor((double) (low+high)/2);
            if (key == arr[mid]){
                return mid;
            }
            else {
                if (key < arr[mid]){
                    return binarySearch_r(arr,low,mid-1,key);
                }
                else {
                    return binarySearch_r(arr,mid+1,high,key);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,8,10,15,18,21,24,27,29,33,34,37,39,41,43};
        int low = 0;
        int high = arr.length;
        int key = 24;
        System.out.println(binarySearch(arr,low,high,key));
        System.out.println(binarySearch_r(arr,low,high,key));
    }
}
