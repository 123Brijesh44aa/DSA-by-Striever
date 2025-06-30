package arrays.leetcode.medium;

import java.util.HashMap;

public class KDiffPairs532 {

    private static int findPairs(int[]arr, int k){
        if (k < 0) {
            return 0;
        }
        // step 1
        // count the frequency of every element and store in HashMap
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int element: arr){
            map.put(element, map.getOrDefault(element, 0)+1);
        }
        // step 2
        // go through each unique number
        for (int num: map.keySet()){
            if (k == 0){
                if (map.get(num) > 1){
                    count++;
                }
            } else {
                if (map.containsKey(num+k)){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[]arr = {3,1,4,1,5,3,4};
        int k = 0;
        System.out.println(findPairs(arr,k));
    }
}
