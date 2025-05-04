package recursions.basics.intermediate;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    static void merge(ArrayList<Integer> arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        // the first array will be from [low...mid]
        // the second array will be from [mid+1...high]
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if (arr.get(left) <= arr.get(right)){
                temp.add(arr.get(left));
                left++;
            }
            else {
                temp.add(arr.get(right));
                right++;
            }
        }

        while (left <= mid){
            temp.add(arr.get(left));
            left++;
        }
        while (right <= high) {
            temp.add(arr.get(right));
            right++;
        }

        for (int i = low; i <= high; i++){
            arr.set(i, temp.get(i - low));
        }
    }

    static void ms(ArrayList<Integer> arr, int low, int high){
        if (low >= high) { return; }
        int mid = (low + high)/2;
        ms(arr, low, mid);
        ms(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    static void mergeSort(ArrayList<Integer> arr, int n){
        ms(arr, 0, n-1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3,1,2,4,1,5,2,6,4));
        mergeSort(arr, arr.toArray().length);

        System.out.println(arr);
    }
}
