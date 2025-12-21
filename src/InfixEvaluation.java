import java.util.Stack;

public class InfixEvaluation {

    private static int precedence(char operator){
        if (operator == '+' || operator == '-'){
            return 0;
        } else {
            return 1;
        }
    }

    private static int operation(int v2, int v1, char op){
        if (op == '+') return v1 + v2;
        else if (op == '-') return v1 - v2;
        else if (op == '*') return v1 * v2;
        else return v1 / v2;
    }

    private static void infixEval(String string){
        int n = string.length();
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i=0; i<n; i++){
            char ch = string.charAt(i);
            if (ch == '('){
                operator.push(ch);
            } else if (ch == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    char op = operator.pop();
                    int result = operation(v2, v1, op);
                    operand.push(result);
                }
                operator.pop();
            } else if ((int) ch >= '0' && (int) ch <= '9') {
                operand.push(ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while (!operator.isEmpty() && operator.peek() != '(' && precedence(operator.peek()) >= precedence(ch)){
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    char op = operator.pop();
                    int result = operation(v2,v1,op);
                    operand.push(result);
                }
                operator.push(ch);
            }
        }

        while (!operator.isEmpty()) {
            int v2 = operand.pop();
            int v1 = operand.pop();
            char op = operator.pop();
            int result = operation(v2,v1,op);
            operand.push(result);
        }

        System.out.println(operand.peek());
    }

    public static void main(String[] args) {
        String string = "9-5+3*4/6";
        infixEval(string);
    }
}
