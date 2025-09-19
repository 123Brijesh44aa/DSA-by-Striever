package oopslab;

public class Dups {
    private static boolean isContainsDups(int[] arr) {
        int n = arr.length;
        if (arr == null || n == 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 4, 4, 5, 6, 7 };
        arr = new int[] { 1, 2, 3, 4, 5, 6 };
        System.out.println("is duplicate : " + isContainsDups(arr));
    }
}
