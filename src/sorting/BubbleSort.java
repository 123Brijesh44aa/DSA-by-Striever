package sorting;

import java.util.Arrays;

public class BubbleSort {

    private static void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void bubbleSort(int[]arr){
        int n = arr.length;
        for (int i=0; i<n-1; i++){
            for (int j=0; j<n-i-1; j++){
                if (arr[j] > arr[j+1]){    // bubble sort me hum sabse bade element ko sabse piche (right side) me bhejte ha
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[]arr = {5,4,3,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
