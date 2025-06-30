package dp;

import java.util.Arrays;

// arr = [5,4,3,2,1]
public class BubbleSortRecursion {
    private static void bubbleSort(int[] arr, int n){
        if (n==0) {
            return;
        }
        for (int i=0; i<n; i++){
            if ((i+1)<n){
                if (arr[i] > arr[i+1]) {
                    System.out.print(arr[i] + " > " + arr[i + 1] + " => swap ( " + arr[i] + " <-> " + arr[i + 1] + " )");
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    System.out.print(" = "+Arrays.toString(arr));
                    System.out.println();
                }
            }
        }
        System.out.println();
        bubbleSort(arr, n-1);
    }


    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        bubbleSort(arr,arr.length);
        System.out.println("sorted array is : "+Arrays.toString(arr));
    }
}
