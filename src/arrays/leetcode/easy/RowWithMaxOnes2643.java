package arrays.leetcode.easy;

import java.util.Arrays;

public class RowWithMaxOnes2643 {

    static int[] rowAndMaximumOnes(int[][]arr){
        int n = arr.length;
        int[]res = new int[2];
        int row = 0;
        int maxOnes = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            int sumOfRow = 0;
            for (int j=0; j<arr[0].length; j++){
                sumOfRow = sumOfRow + arr[i][j];
            }
            if (sumOfRow > maxOnes){
                maxOnes = sumOfRow;
                row = i;
            }
        }
        res[0] = row;
        res[1] = maxOnes;
        return res;
    }

    public static void main(String[] args) {
        int[][]arr = {
                {0,0,0},
                {0,1,1},
                {1,0,0},
                {0,0,1},
        };

        System.out.println(Arrays.toString(rowAndMaximumOnes(arr)));
    }
}
