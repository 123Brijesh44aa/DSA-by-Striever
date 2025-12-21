package sorting;

import java.util.Arrays;

public class LomutoQuickSort {

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j<high; j++){
            if (arr[j] <= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);

        return (i+1);
    }

    private static void quickSort(int[] arr, int low, int high){
       if(low < high) {
           int pi = partition(arr, low, high);
           quickSort(arr, low, pi - 1);
           quickSort(arr, pi + 1, high);
       }
    }

    public static void main(String[] args) {
        int[] arr = {10,80,30,90,40,50,70};
        int n = arr.length;
        quickSort(arr,0,n-1);

        System.out.println("Sorted Array is : "+ Arrays.toString(arr));
    }
}
