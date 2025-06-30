package sorting;

import java.util.Arrays;

public class InsertionSort {

    private static void insertionSort(int[]arr){
        int n = arr.length;
        for (int i=1; i<n; i++){
            int j = i - 1;
            int x = arr[i];
            while (j > -1 && arr[j] > x){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = x;
        }
    }

    public static void main(String[] args) {
        int[]arr = {5,4,3,2,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
