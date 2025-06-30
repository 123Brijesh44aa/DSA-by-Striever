import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_0 {

    // brute force approach
    private static int[] nge_brute(int[]arr){
        int n = arr.length;
        int[] nge = new int[n];
        Arrays.fill(nge,-1);
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if (arr[j] > arr[i]){
                    nge[i] = arr[j];
                    break;
                }
            }
        }
        return nge;
    }

    // better approach
    private static int[] nge(int[]arr){
        int n = arr.length;
        int[]nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=n-1; i>=0; i--){
            while (!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                nge[i] = -1;
            }
            else {
                nge[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int[]arr = {4,12,5,3,1,2,5,3,1,2,4,6};
        arr = new int[]{6,0,8,1,3};
        System.out.println("Array of next greater element is : "+ Arrays.toString(nge_brute(arr)));
        System.out.println("Array of next greater element is : "+ Arrays.toString(nge(arr)));
    }
}
