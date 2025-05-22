package sorting;

import java.util.Arrays;

public class SelectionSort {

    private static void swap(int[]arr, int i, int minIndex){
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    private static void selectionSort(int[]arr){
        int n = arr.length;
        for (int i=0; i<n-1; i++){
            int minIndex = i;
            for (int j=i+1; j<n; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    public static void main(String[] args) {
        int[]arr = {44,33,55,22,11};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
