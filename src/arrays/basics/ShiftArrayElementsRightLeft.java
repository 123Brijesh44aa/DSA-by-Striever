package arrays.basics;

import java.util.Arrays;

public class ShiftArrayElementsRightLeft {

    static int[] shiftRightside_by_1(int[]arr){
        int temp = arr[arr.length-1];
        for (int i = arr.length - 1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        return arr;
    }

    static int[] rightShiftByN(int[]arr,int shiftBy){

        if (shiftBy == 0) return arr;

        if (shiftBy < 0){
           // Left shift
            return leftShiftByN(arr, -shiftBy);
        }

        shiftBy = shiftBy % arr.length;

        if (shiftBy == 0) return arr;

        int[]temp = new int[shiftBy];
        for (int i=0; i<shiftBy; i++){
            temp[i] = arr[arr.length-shiftBy+i];
        }
        for (int j=arr.length-1; j>=shiftBy; j--){
            arr[j] = arr[j-shiftBy];
        }
        for (int k=0; k<shiftBy; k++){
            arr[k] = temp[k];
        }
        return arr;
    }

    static int[] leftShiftByN(int[]arr, int shiftBy){
        if (shiftBy == 0) return arr;
        if (shiftBy < 0){
            return rightShiftByN(arr, -shiftBy);
        }
        shiftBy = shiftBy%arr.length;
        if (shiftBy == 0) return arr;
        int[]temp = new int[shiftBy];
        for (int i=0; i<shiftBy; i++){
            temp[i] = arr[i];
        }
        for (int j=0; j<arr.length-shiftBy; j++){
            arr[j] = arr[shiftBy+j];
        }
        for (int k=0; k<shiftBy; k++){
            arr[arr.length-shiftBy+k] = temp[k];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[]arr = {10,20,30,40,50,60};
        System.out.println(Arrays.toString(rightShiftByN(arr,-98)));
    }
}
