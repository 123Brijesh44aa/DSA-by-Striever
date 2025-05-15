package arrays.leetcode.medium;

public class RotateImage90Degree48 {


    // Brute force approach
    static int[][] rotate_brute_force(int[][]arr){
        int[][]resultMatrix = new int[arr.length][arr[0].length];
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                resultMatrix[j][arr.length-i-1] = arr[i][j];
            }
        }
        return resultMatrix;
    }

    // Approach:
    // Transpose + Reverse Matrix
    static void transpose(int[][]arr){
        int n = arr.length;
        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    static void reverse(int[]arr){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        for (int i=0; i<n/2; i++){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    static void rotate(int[][]arr){
        transpose(arr);
        for (int[] ints : arr) {
            reverse(ints);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

//        print2D(rotate_brute_force(arr));

        System.out.println("\n Original Matrix");
        print2D(arr);
        rotate(arr);
        System.out.println("\n 90 Degree Rotated Matrix");
        print2D(arr);

    }

    private static void print2D(int[][] arr) {
        for (int[] ints : arr) {
            StringBuilder record = new StringBuilder();
            for (int j = 0; j < arr[0].length; j++) {
                record.append(ints[j]).append("  ");
            }
            System.out.println(record);
        }
    }
}
