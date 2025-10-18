
import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int totalElementsLessThanPivot = 0;
        for (int i = start + 1; i <= end; i++) { // we must skip comparing the pivot with itself and still include the element at index end that why we use i=start+1 to end inclusive. if we start at start we double count the pivot; if we stop at end-1 we miss arr[end].
            if (arr[i] <= pivot) { // we added <= because we want all the duplicate elements at left side
                totalElementsLessThanPivot++;
            }
        }
        int pivotIndex = start + totalElementsLessThanPivot;
        swap(arr, start, pivotIndex);
        // swapping
        int i = start;
        int j = end;
        while (i < pivotIndex && j > pivotIndex) {
            while (i < pivotIndex && arr[i] <= pivot) {
                i++;
            }
            while (j > pivotIndex && arr[j] > pivot) {
                j--;
            }

            if (i < pivotIndex && j > pivotIndex) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return pivotIndex;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = {7, 13, 8, 5, 10, 2, 4};
        int start = 0;
        int end = arr.length - 1;
        quickSort(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }
}
