package arrays.basics;

public class MinInArray {

    static int findMinFromArray(int[]arr){
        int min = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++){
          if (arr[i] < min){
              min = arr[i];
          }
        }
        return min;
    }

    // Another way
    static int findMinFromArray_2(int[]arr){
        int min = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++){
            min = Math.min(arr[i], min);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {8,3,-5,9,2,7,1};
        System.out.println(findMinFromArray(arr));
        System.out.println(findMinFromArray_2(arr));
    }
}
