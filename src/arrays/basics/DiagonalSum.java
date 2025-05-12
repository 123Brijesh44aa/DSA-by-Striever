package arrays.basics;

public class DiagonalSum {

    static int diagonalSum(int[][]arr) {
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            sum = sum + arr[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][]arr;
        arr = new int[][]{
                {1, 2, 3, 4,},
                {4, 6, 7, 9},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        int sum = diagonalSum(arr);
        System.out.println(sum);
    }
}
