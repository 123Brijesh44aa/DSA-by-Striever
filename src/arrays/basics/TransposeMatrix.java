package arrays.basics;

import java.util.Arrays;

public class TransposeMatrix {


    // Transpose method: works only for square matrices
    // this is an in place approach
    static void transpose_square_matrix(int[][]arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < arr[i].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }


    // Works for both Square Matrix and Rectangular Matrices
    static int[][] transpose(int[][]arr){
        int m = arr.length;   // eg . 4
        int n = arr[0].length;  // eg. 3
        int[][]transposedMatrix;
        if (m == n) {
            transposedMatrix = new int[m][n];
            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    transposedMatrix[i][j] = arr[j][i];
                }
            }
            return transposedMatrix;
        }
        else {
            // before transpose matrix will be of mxn
            // after transpose matrix will be of nxm
            transposedMatrix = new int[n][m];
            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    transposedMatrix[j][i] = arr[i][j];
                }
            }
            return  transposedMatrix;
        }
    }


    public static void main(String[] args) {
        int[][]arr = {
                {1,2,3,44},
                {4,5,6,49},
                {7,8,9,77},
                {32,98,43,53},
                {10,20,30,40}
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
