package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    void merge(int[]arr, int start, int mid, int end){
        ArrayList<Integer> temp = new ArrayList<>();
        int i = start;
        int j = mid+1;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else{
                temp.add(arr[j]);
                j++;
            }
        }

        // add remaining elements of first half if available
        while (i <= mid) {
            temp.add(arr[i]);
            i++;
        }

        // add remaining elements of second half if available
        while (j <= end) {
            temp.add(arr[j]);
            j++;
        }

        // add temp elements to the original array
        for(int index = 0; index < temp.size(); index++){
            arr[index+start] = temp.get(index);
        }
    }

    void mergeSort(int[]arr, int start, int end){
        int mid;
        if (start < end) {
            mid = start + (end-start)/2;
            mergeSort(arr, start, mid); // left half
            mergeSort(arr, mid+1, end); // right half

            merge(arr,start,mid,end);
        }
    }

    public static void main(String[] args) {
        int[]arr = {12,31,35,8,32,17};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
