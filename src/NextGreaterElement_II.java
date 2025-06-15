import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_II {

    // Approach 1
    private static int[] ngeII(int[]arr){
        int n = arr.length;
        int[]res = new int[n];
        Arrays.fill(res, -1);
        for (int i=0; i<n; i++){
            for (int j=i+1; j<i+n-1; j++){
                int index = j%n;
                if (arr[index] > arr[i]){
                    res[i] = arr[index];
                    break;
                }
            }
        }
        return res;
    }

    private static int[] ngeII_optimal(int[]arr){
        int n = arr.length;
        Stack<Integer> stack  = new Stack<>();
        int[]res = new int[n];
        for (int i=2*n-1; i>=0; i--){
            while (!stack.isEmpty() && stack.peek() <= arr[i%n]){
                stack.pop();
            }
            if (stack.isEmpty()){
                res[i%n] = -1;
            } else {
                res[i%n] = stack.peek();
            }
            stack.push(arr[i%n]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,10,12,1,11};
        System.out.println("Next Greater Element II : "+ Arrays.toString(ngeII(arr)));

        // using optimal solution
        System.out.println("Next Greater Element II is : "+ Arrays.toString(ngeII_optimal(arr)));
    }
}
