package recursions.basics;

import java.util.ArrayList;

public class PrintingSubsequence {

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

    public static void main(String[] args) {
        PrintingSubsequence subsequence = new PrintingSubsequence();
        int[] arr = {1,2,3,4};
        ArrayList<Integer> arrayList = new ArrayList<>();
        subsequence.printingSubsequence(0, arr, arrayList);
    }
}
