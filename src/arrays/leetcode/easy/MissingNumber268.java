package arrays.leetcode.easy;

public class MissingNumber268 {

    static int missingNumber(int[]arr){
        int sumN = 0;
        int sumN_1 = 0;
        for (int i=0; i<arr.length+1; i++){
            sumN = sumN + i;
        }
        for (int j=0; j<arr.length; j++){
            sumN_1 = sumN_1 + arr[j];
        }
        return sumN - sumN_1;
    }

    public static void main(String[] args) {
        int[]arr = {3,0,1,2,5};
        int missingNumber = missingNumber(arr);
        System.out.println(missingNumber);
    }
}
