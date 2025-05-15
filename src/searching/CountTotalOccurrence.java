package searching;

public class CountTotalOccurrence {

    static int firstOcc(int[]arr, int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid = (start+end)/2;
        int first = -1;
        for (int i=0; i<n/2; i++){
            if (target == arr[mid]){
                first = mid;
                end = mid-1;
                mid = (start+end)/2;
            }
            if (target < arr[mid]){
                end = mid-1;
                mid = (start+end)/2;
            }
            if (target > arr[mid]){
                start = mid+1;
                mid = (start+end)/2;
            }
        }
        return first;
    }

    static int lastOcc(int[]arr, int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid = (start+end)/2;
        int last = -1;
        for (int i=0; i<n/2; i++){
            if (target == arr[mid]){
                last = mid;
                start = mid + 1;
                mid = (start+end)/2;
            }
            if (target < arr[mid]){
                end = mid-1;
                mid = (start+end)/2;
            }
            if (target > arr[mid]){
                start = mid + 1;
                mid = (start+end)/2;
            }
        }
        return last;
    }

    static int totalOccurrence(int[]arr, int target){
        int firstOccurrence = firstOcc(arr,target);
        int lastOccurrence = lastOcc(arr,target);
        return (lastOccurrence - firstOccurrence) + 1;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,3,4,4,4,5,5,5,5,5};
        int target = 5;
        System.out.println(totalOccurrence(arr,target));

    }
}
