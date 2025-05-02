package recursions.basics;

import java.util.ArrayList;

public class PrintingSubsequence {

    // Printing all Subsequence
    void printingSubsequence(int index, int[] arr, ArrayList<Integer> arrayList){
        if (index >= arr.length){
            System.out.println(arrayList);
            return;
        }
        arrayList.add(arr[index]);
        printingSubsequence(index+1, arr, arrayList); // take
        arrayList.remove(arrayList.size() - 1); // OR we can use arrayList.removeLast();
        printingSubsequence(index+1, arr, arrayList); // not take
    }

    // Printing Subsequence whose Sum is K
    void printingSubsequenceSumK(int index, int[] arr, ArrayList<Integer> arrayList, int initialSum, int targetSum){
        if (index == arr.length){
            if (initialSum == targetSum){
                System.out.println(arrayList);
            }
            return;
        }
        // Take current element
        arrayList.add(arr[index]);
        initialSum += arr[index];
        printingSubsequenceSumK(index+1, arr, arrayList, initialSum, targetSum);

        // Don't take current element
        arrayList.remove(arrayList.size() - 1);
        initialSum -= arr[index];
        printingSubsequenceSumK(index+1, arr, arrayList, initialSum, targetSum);
    }

    void printNto1(int n){
        if (n == 0){
            return;
        }
        System.out.println(n);
        printNto1(n-1);
    }

    void print1toN(int n){
        if (n == 0){
            return;
        }
        print1toN(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        PrintingSubsequence subsequence = new PrintingSubsequence();
        int[] arr = {1,2,3,4};
        ArrayList<Integer> arrayList = new ArrayList<>();
        subsequence.printingSubsequence(0, arr, arrayList);
        System.out.println("\n\n");
        int[] arr2 = {2,4,6};
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        subsequence.printingSubsequenceSumK(0, arr2, arrayList2, 0, 6);

        System.out.println("\n\n");
        subsequence.printNto1(10);
        System.out.println();
        subsequence.print1toN(10);
    }
}
