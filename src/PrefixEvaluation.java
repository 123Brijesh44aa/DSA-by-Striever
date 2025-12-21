import java.util.Stack;

public class PrefixEvaluation {

    private static int operation(int v1, int v2, char op){
        if (op == '+') return v1 + v2;
        else if (op == '-') return v1 - v2;
        else if (op == '*') return v1 * v2;
        else return v1 / v2;
    }

    private static void prefixEval(String string){
        int n = string.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i>=0; i--){
            char ch = string.charAt(i);
            if ((int) ch >= '0' && (int)ch <= '9'){
                stack.push((int)ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                int v1 = stack.pop();
                int v2 = stack.pop();
                int result = operation(v1,v2,ch);
                stack.push(result);
            }
        }
        System.out.println("Result is : "+stack.pop());
    }

    public static void main(String[] args) {
        String string = "*+69-31";
        prefixEval(string);
    }
}
