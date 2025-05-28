package arrays.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoSortedArrays {

    private static int[] getIntersection(int[]a, int[] b){
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> intersection = new ArrayList<>();
        while (i < n && j < m){
            while ((i+1) < n && a[i] == a[i+1] ){
                i++;
            }
            while((j+1) < m && b[j] == b[j+1]){
                j++;
            }
            if (a[i] < b[j]){
                i++;
            }
            else if (b[j] < a[i]){
                j++;
            }
            else {
                intersection.add(a[i]);
                i++;
                j++;
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[]arr = {0,0,0,0,1,1,1,2,3,4,5};
        int[]arr2 = {0,0,0,0,1,1,2,2,2,2,3,4,4,5,8,9,9,9,9};
        System.out.println(Arrays.toString(getIntersection(arr,arr2)));
        arr = new int[]{1,2,3,4,5};
        arr2 = new int[]{1,2,3,6,7};
        System.out.println(Arrays.toString(getIntersection(arr,arr2)));
        arr = new int[]{1,2,3};
        arr2 = new int[]{1,2,3};
        System.out.println(Arrays.toString(getIntersection(arr,arr2)));
    }
}
