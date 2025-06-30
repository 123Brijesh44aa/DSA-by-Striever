import java.util.Arrays;

public class MaximumSubarraySum53 {


    // there are 2 variety of this question

    // first 1.
    // return the maximum sum of subarray
    private static int maxSubArray(int[]arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            int start = 0;
            if (sum == 0) {
                start = i;
            }
            sum = sum + arr[i];
            if (sum > max){
                max = sum;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        return max;
    }


    // second 2.
    // return the first index and last index of the maximum sub array sum
    private static int[] maxSubArray_2(int[] arr){
        int max = Integer.MIN_VALUE;
        int ansStart = -1;
        int ansEnd = -1;
        int sum = 0;
        int start = 0;
        for (int i=0; i<arr.length; i++){
            if (sum == 0){
                start = i;
            }
            sum = sum + arr[i];
            if (sum > max){
                max = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        int[]res = new int[2];
        res[0] = ansStart;
        res[1] = ansEnd;
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Max sum of subarray is : "+ maxSubArray(arr));

        System.out.println("start and end index of max sub array sum : "+Arrays.toString(maxSubArray_2(arr)));
    }
}
