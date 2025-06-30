package arrays.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {

    private static int removeDuplicates(int[]arr){
        int n = arr.length;
        int i = 0;
        for (int j=1 ; j<n; j++){
            if (arr[j] != arr[i]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return (i+1);
    }

    public static void main(String[] args) {
        int[]arr = {1,1,2,2,3,3,3,8,8,9,9,9,9,9};
        System.out.println(removeDuplicates(arr));
    }
}
