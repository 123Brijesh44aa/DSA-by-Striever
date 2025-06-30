package arrays.basics;

import java.util.Arrays;

public class PrintExtreme {

    static void printExtreme(int[]arr){
        for (int i=0, j=arr.length-1; i<arr.length/2; i++, j--){
            System.out.println(arr[i]);
            System.out.println(arr[j]);
        }
        if (arr.length % 2 != 0){
            System.out.println(arr[arr.length/2]);
        }
    }

    static int[] extremeArray(int[] arr){
        int[]ext = new int[arr.length];
        int index = 0;
        for (int i=0, j=arr.length-1; i<arr.length/2; i++, j--){
            ext[index++] = arr[i];
            ext[index++] = arr[j];
        }
        if (arr.length % 2 != 0){
            ext[index] = arr[arr.length/2];
        }
        return ext;
    }

    public static void main(String[] args) {
        int[]arr = {10,20,30,40,50,60,70};
        printExtreme(arr);
        System.out.println(Arrays.toString(extremeArray(arr)));
    }
}
