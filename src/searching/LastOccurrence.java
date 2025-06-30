package searching;

public class LastOccurrence {

    static int lastOccurrence(int[]arr, int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid = (start+end)/2;
        int ans = -1;
        for (int i=0; i<n/2; i++){
            if (target == arr[mid]){
                ans = mid;
                start = mid+1;
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
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,3,3,3,4,4,4};
        int target = 3;
        System.out.println(lastOccurrence(arr,target));

    }
}
