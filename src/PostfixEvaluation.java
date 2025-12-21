import java.util.Stack;

public class PostfixEvaluation {

    private static int operation(int v2, int v1, char op){
        if (op == '+') return v1+v2;
        else if (op == '-') return v1-v2;
        else if (op == '*') return v1*v2;
        else return v1/v2;
    }

    private static Integer postfixEval(String string) {
        int n = string.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<n; i++){
            char ch = string.charAt(i);
            if ((int)ch >= (int)'0' && (int)ch <= (int)'9'){
                stack.push(ch - (int)'0');
            } else if (ch == '-' || ch == '+' || ch == '*' || ch == '/') {
                int v2 = stack.pop();
                int v1 = stack.pop();
                int result = operation(v2,v1,ch);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String string = "53+82-*";
        System.out.println("result is : "+postfixEval(string));
    }
}
