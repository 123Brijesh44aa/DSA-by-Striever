package arrays.basics;

public class RowColumnWiseSum {

    static void rowWiseSum(int[][]arr, int rows, int cols){
        for (int i=0; i<rows; i++){
            int sum = 0;
            for (int j=0; j<cols; j++){
                sum = sum + arr[i][j];
            }
            System.out.println(sum);
        }
    }

    static void columnWiseSum(int[][]arr, int rows, int cols){
        for (int i=0; i<cols; i++){
            int sum = 0;
            for (int j=0; j<rows; j++){
                sum = sum + arr[j][i];
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        int rows = 4;
        int cols = 3;
        int[][]arr;
        arr = new int[][]{
                {1, 2, 3},
                {3, 6, 9},
                {5, 5, 9},
                {3, 4, 1},
        };
        System.out.println("\nRow wise sum:");
        rowWiseSum(arr,rows,cols);
        System.out.println();
        System.out.println("Column wise sum");
        columnWiseSum(arr,rows,cols);
    }
}
