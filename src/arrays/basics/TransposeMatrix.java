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

    // another method: by swaping row,column to column, row,
    // but this method works for only square matrices.
    // e.g., 3x3, 2x2, 5x5
    // if you try to give it non-square matrix, you will end up getting IndexOutOfBoundException.
    static int[][] transpose2(int[][]arr){
        int rows = arr.length;
        int cols = arr[0].length;
        for (int i=0; i<rows; i++){
            for (int j=i; j<cols; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[][]arr = {
                {1,2,3,44,32,90},
                {4,5,6,49,55,66},
                {7,8,9,77,88,99},
                {32,98,43,53,23,53},
                {38,58,20,83,52,39},
                {59,89,33,50,19,15}
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
        arr = transpose2(arr);
        for (int i=0; i<arr.length; i++){
            StringBuilder row = new StringBuilder();
            for (int j=0; j<arr[0].length; j++){
                row = row.append(arr[i][j]).append(",");
            }
            System.out.println(row);
        }
    }
}
