package arrays.leetcode.medium;

public class FindingMissingNumber {


    private static int missingNumber(int[]arr){
        int n = arr.length+1;
        int totalSum = n*(n+1)/2;
        int sum = 0;
        for (int j : arr) {
            sum = sum + j;
        }
        return totalSum-sum;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,4,5};
        System.out.println(missingNumber(arr));
    }
}
