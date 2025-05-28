package arrays.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOfTwoSortedArrays {

    // union contains only common and distinct elements

    private static int[] getUnion(int[]a , int[]b){
        int n = a.length;
        int m = b.length;
        ArrayList<Integer> union = new ArrayList<>();
        int i=0;
        int j=0;
        while (i < n && j < m){
            // 1. edge case: if the same elements in an array 'a'
            while ( (i+1) < n && a[i] == a[i+1]){
                i++; // skip the element and move it by 1
            }
            while ( (j+1) < m && b[j] == b[j+1]){
                j++;
            }

            if (a[i] < b[j]){
                union.add(a[i]);
                i++;
            }
            else if (b[j] < a[i]){
                union.add(b[j]);
                j++;
            }
            else {
                // both elements are the same then
                union.add(a[i]);
                i++;
                j++;
            }

        }
        // storing remaining elements of 'a'
        while (i < n){
            while ( (i+1) < n && a[i] == a[i+1]){
                i++;
            }
            union.add(a[i]);
            i++;
        }

        // storing remaining elements of 'b'
        while (j < m) {
            while ((j + 1) < m && b[j] == b[j + 1]) {
                j++;
            }
            union.add(b[j]);
            j++;
        }
        return union.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[]arr = {0,0,0,0,1,1,1,2,3,4,5};
        int[]arr2 = {0,0,0,0,1,1,2,2,2,2,3,4,4,5,8,9,9,9,9};
        System.out.println(Arrays.toString(getUnion(arr,arr2)));
    }
}
