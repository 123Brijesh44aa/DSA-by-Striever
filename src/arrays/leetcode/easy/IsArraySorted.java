package arrays.leetcode.easy;

public class IsArraySorted {

    private static boolean isSorted(int[]arr){
        int n = arr.length;
        for (int i=0; i<n-1; i++){
            if (arr[i] > arr[i+1]){
               return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,2,3,3,4};
        System.out.println(isSorted(arr));
        arr = new int[]{1,2,1,3,4};
        System.out.println(isSorted(arr));
    }
}
