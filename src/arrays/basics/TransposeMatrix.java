package arrays.basics;

import java.util.Arrays;

public class TransposeMatrix {

    static int[][] transpose(int[][]arr){
        int rows = arr.length;
        int cols = arr[0].length;
        int[][]transposedMatrix = new int[rows][cols];
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                transposedMatrix[i][j] = arr[j][i];
            }
        }
        return transposedMatrix;
    }

    public static void main(String[] args) {
        int[][]arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println("Original Matrix");
        for (int i=0; i<arr.length; i++){
            StringBuilder row = new StringBuilder();
            for (int j=0; j<arr[0].length; j++){
                row = row.append(arr[i][j]).append(",");
            }
            System.out.println(row);
        }
        System.out.println("Transposed Matrix");
        arr = transpose(arr);
        for (int i=0; i<arr.length; i++){
            StringBuilder row = new StringBuilder();
            for (int j=0; j<arr[0].length; j++){
                row = row.append(arr[i][j]).append(",");
            }
            System.out.println(row);
        }
    }
}
