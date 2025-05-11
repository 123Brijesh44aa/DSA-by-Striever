package arrays.basics;

import java.util.Arrays;

public class SortZerosOnes {

    static int[] sort(int[]arr){
        int zeros = 0;
        int ones = 0;
        int[]sorted = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            if (arr[i] == 0){
                zeros++;
            }
            else {
                ones++;
            }
        }
        for (int j = 0; j<zeros+ones; j++){
            sorted[j] = 0;
            if (j >= zeros){
                sorted[j] = 1;
            }
        }
//        for (int k = zeros; k<zeros+ones; k++){
//            sorted[k] = 1;
//        }
        return sorted;
    }

    public static void main(String[] args) {
        int[]arr = {0,1,0,1,1,0,0,0,1,0,1,1,0,1,1,1};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
