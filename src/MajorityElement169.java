import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

    // brute force
    private static int majorityElement(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return arr[i];
            }
        }
        return -1;
    }

    // better approach using hashing
    private static int majorityElement_better(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > n / 2) {
                return key;
            }
        }
        return -1;
    }

    // optimal approach
    // Moore's Voting algorithm
    private static int majorityElement_optimal(int[] arr) {
        int n = arr.length;
        int count = 0;
        int element = -1;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = arr[i];
            } else if (arr[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 3, 3,3, 1, 3, 2 };
        System.out.println("Majority element from the array is : " + majorityElement(arr));
        System.out.println("Majority element from the array is : " + majorityElement_better(arr));
        System.out.println("Majority element from the array is : " + majorityElement_optimal(arr));

    }
}