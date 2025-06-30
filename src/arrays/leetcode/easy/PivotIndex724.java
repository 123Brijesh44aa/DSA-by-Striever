package arrays.leetcode.easy;

public class PivotIndex724 {

    static int pivotIndex(int[]arr){
        int n = arr.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }
        int leftSum = 0;
        int rightSum;
        for(int i=0; i<n; i++){
            rightSum = total - leftSum - arr[i];
            if (leftSum == rightSum){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]arr = {1,7,3,3,2,3};
        System.out.println(pivotIndex(arr));
    }
}
