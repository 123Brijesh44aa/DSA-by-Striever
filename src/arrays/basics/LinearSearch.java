package arrays.basics;

import java.util.Arrays;

public class LinearSearch {

    static int linearSearch(int[]arr, int key){
        for (int i = 0; i<arr.length; i++){
            if (key == arr[i]){
                return i;
            }
        }
        return -1;
    }


    static void swap(int[]arr, int a, int b){
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Improving Linear Search (Transposition Method)
    static int linearSearch_transposition(int[] arr, int key ){
        for (int i=0; i<arr.length; i++){
            if (key == arr[i]){
                if (i>0){ // check to prevent array index out of bounds
                    swap(arr, i, i-1);
                }
                return i;
            }
        }
        return -1;
    }

    // Improving linear Search More using (Move to Front/Head method)
    static int linearSearch_movetoFront(int[]arr, int key){
        for (int i=0; i<arr.length; i++){
            if (key == arr[i]){
                swap(arr,i,0);
                return 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8,9,4,7,6,5,3,10,14,2};
        int key = 14;

        System.out.println(Arrays.toString(arr));

        System.out.println(linearSearch(arr,key));
        System.out.println(Arrays.toString(arr));

        System.out.println(linearSearch_transposition(arr,key));
        System.out.println(Arrays.toString(arr));

        System.out.println(linearSearch_movetoFront(arr,key));
        System.out.println(Arrays.toString(arr));
    }
}
