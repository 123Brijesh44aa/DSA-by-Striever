import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {

    // brute force
    private static int[] pse(int[]arr){
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i=0; i<n; i++){
            for (int j=i-1; j>=0; j--){
                if (arr[j] < arr[i]){
                    res[i] = arr[j];
                    break;
                }
            }
        }
        return res;
    }

    // optimal solution
    // using stack
    private static int[] pse_optimal(int[]arr){
        int n = arr.length;
        int[]res = new int[n];
        Stack<Integer> stack  = new Stack<>();
        for (int i=0; i<n; i++){
            while (!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[]arr = {4,5,2,10,8};
        System.out.println("Previous Smaller element array is : "+Arrays.toString(pse(arr)));
        System.out.println("Previous smaller element array is (optimal code) : "+Arrays.toString(pse_optimal(arr)));
    }
}
