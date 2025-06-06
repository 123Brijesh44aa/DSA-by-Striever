import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    // Two type:
    // 1 type : return true/false
    // 2 type : return indexes of elements

    // Brute Force Approach
    private static boolean twoSum(int[] arr, int target) {
        int n = arr.length;
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Brute force approach
    private static int[] twoSum_(int[] arr, int target) {
        int n = arr.length;
        if (n == 0 || n == 1) {
            return new int[] {};
        }
        int[] index = new int[2];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (i == j) {
                    continue;
                }
                if (arr[i] + arr[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
        }
        return index;

    }


    // Better approach using Hashing 
    private static boolean twoSum_better(int[]arr, int target){
        int n = arr.length;
        if (n==0 || n==1) {
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if (!map.containsKey(target-arr[i])) {
                map.put(arr[i], i);
            } else{
                return true;
            }
        }
        return false;
    }
    private static int[] twoSum_better_(int[]arr, int target){
        int n = arr.length;
        if (n==0 || n==1) {
            return new int[]{};
        }
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i<n; i++){
            if (!map.containsKey(target - arr[i])) {
                map.put(arr[i], i);
            } else{
                res[0] = i;
                res[1] = map.get(target-arr[i]);
            }
        }
        return res;
    }

    // optimal approach
    // works only for type 1
    private static boolean twoSum_optimal_type1(int[]arr, int target){
        int n = arr.length;
        if (n==0 || n==1) {
            return false;
        }
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            }
            else if (sum < target) {
                left++; 
            }
            else {
                right--;
            }
        }
        return false;
    }
    

    public static void main(String[] args) {
        int[] arr = { 2, 6, 5, 8, 11 };
        int target = 14;
        System.out.println(twoSum(arr, target));
        System.out.print("index of the elements whose sum is = target are : ");
        System.out.println(Arrays.toString(twoSum_(arr, target)));

        // using hashing 
        System.out.println(twoSum_better(arr, target));
        System.out.println(Arrays.toString(twoSum_better_(arr, target)));

        // optimal approach : two pointers
        System.out.println(twoSum_optimal_type1(arr, target));
    }
}
