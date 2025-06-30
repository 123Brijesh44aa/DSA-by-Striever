import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_I {

    // brute force approach
    // array 'a' is subset of array 'b'
    // and every element is unique in a and b
    private static int[] nge(int[] a, int[] b){
        int[]res = new int[a.length];
        Arrays.fill(res,-1);
        for (int i=0; i<a.length; i++){
            boolean found = false;
            for (int k : b) {
                if (a[i] == k) {
                    found = true;
                }
                if (found && k > a[i]) {
                    res[i] = k;
                    break;
                }
            }
        }
        return res;
    }

    // optimal solution
    // hashmap
    private static int[] nge_optimal(int[] nums1, int[] nums2){
        int[]result = new int[nums1.length];
        Arrays.fill(result, -1);
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2){
            // While stack is not empty and current number is greater than stack's top
            while (!stack.isEmpty() && num > stack.peek()){
                // The current number is the next greater element for the stack's top
                map.put(stack.pop(), num);
            }
            // push the current number to the stack
            stack.push(num);
        }

        // for remaining elements put -1
        while (!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        for (int i=0; i<nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {4,1,2};
        int[] b = {1,3,4,2};
        System.out.println("next greater element of array 'a' is : "+Arrays.toString(nge(a,b)));

        // using optimal code
        int[] aa = {4,1,2};
        int[] bb = {1,3,4,2};
        System.out.println("next greater element of array 'aa' is : "+Arrays.toString(nge(aa, bb)));
    }
}
