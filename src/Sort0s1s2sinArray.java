import java.util.Arrays;

public class Sort0s1s2sinArray {

    // brute force approach
    // Sort the Array
    // T(n) = O(nlogn)

    // better approach
    // count the frequency of 0s, 1s and 2s
    private static void sort(int[]arr){
        int n = arr.length;
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int i=0; i<n; i++){
            if (arr[i] == 0) {
                c0++;
            } else if (arr[i] == 1) {
                c1++;
            } else {
                c2++;
            }
        }
        for(int i=0; i<c0; i++){
            arr[i] = 0;
        }
        for(int i=c0; i<c0+c1; i++){
            arr[i] = 1;
        }
        for(int i=c0+c1; i<n; i++){
            arr[i] = 2;
        }
    }

    // Best Optimal approach 
    // Dutch National Flag Algorithm
    private static void sort_optimal(int[]arr){
        int n = arr.length;
        // 3 pointers
        int low = 0;
        int mid = 0;
        int high = n-1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                // swap mid and low and update low and mid by one
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                // swap mid and high and update high by one
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[]arr = {1,2,0,0,1,1,2,0,2,1,1,1,0,0,2};
        sort_optimal(arr);
        System.out.println(Arrays.toString(arr));

        
    }
}
