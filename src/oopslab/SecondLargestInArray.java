package oopslab;

public class SecondLargestInArray {

    // input = [4,9,2,8,1,5,3,6,7]
    // output = secondLargest = 8

    private static int secondLargest(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (i == 2) {
                    break;
                }
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
        return arr[1];
    }

    public static void main(String[] args) {
        int[] arr = { 4, 9, 2, 8, 1, 5, 3, 6, 7 };
        System.out.println("second largest is : " + secondLargest(arr));
    }
}
