package arrays.leetcode.medium;

import java.util.HashMap;

public class FindElementThatAppearsOnce {

    // brute force approach
    private static int findElement(int[]arr){
        int n = arr.length;
        for (int i=0; i<n; i++){
            int num = arr[i];
            int count = 0;
            for (int j=0; j<n; j++){
                if (arr[j] == num){
                    count++;
                }
            }
            if (count == 1){
                return num;
            }
        }
        return -1;
    }

    // better approach
    private static int findElement_better(int[]arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num: arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for (int key: map.keySet()){
            if (map.get(key) == 1){
                return map.get(map.get(key));
            }
        }
        return -1;
    }

    // optimal solution
    // using xor
    private static int findElement_optimal(int[]arr){
        int result = 0;
        for (int num: arr){
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[]arr = {1,1,2,3,3,4,4};
        System.out.println(findElement(arr));

        System.out.println(findElement_better(arr));

        System.out.println(findElement_optimal(arr));
    }
}
