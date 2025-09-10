
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    // problem description
    // Given an integer array nums and an integer k, return the k most frequent
    // elements. you may return the answer in any order.
    // Example :
    // i/o => nums = [1,1,1,2,2,3], k = 2
    // o/p => [1,2]

    // i/o => nums[1,2,1,2,1,2,3,1,3,2], k = 2
    // o/p => [1,2]

    // APPROACH 1 :
    // STEP 1 : count the frequency of each element and store in Hashmap
    // sort the hashmap besed on frequency and then create a array of top K elements
    // and return the last k elements from the HashMap.

    // time complexity in this approach : O(n) for iterating array + O(n logn) for
    // sorting
    // space : O(n) for hashmap

    // APPROACH 2 : HashMap + Priority Queue(Min Heap)
    // Step 1: count the frequency of each element and store in HashMap
    // Step 2: create a Priority Queue(Min Heap) which keeps minimum elements at
    // top,
    // and the size of priorityQueue must not exceed k

    // approach 2: Code
    private static int[] topK(int[] arr, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int element : arr) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> frequencyMap.get(a) - frequencyMap.get(b));

        for (int key : frequencyMap.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll(); // Retrieves and removes the head of this queue, or returns null if this queue
                                // is empty.
            }
        }

        // extract result
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
