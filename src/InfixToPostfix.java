import java.util.Stack;

public class InfixToPostfix {

    private static boolean isOperand(char ch) {
        return (ch >= 'A' && ch <= 'Z' ||
                ch >= 'a' && ch <= 'z' ||
                ch >= '0' && ch <= '9');
    }

    private static int priority(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    private static boolean isRightAssociative(char ch) {
        return ch == '^';
    }

    private static String infixToPostfix(String string) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < string.length()) {
            Character ch = string.charAt(i);
            if (isOperand(ch)) {
                ans.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        (priority(ch) < priority(stack.peek()) ||
                                (priority(ch) == priority(stack.peek()) && !isRightAssociative(ch)))) {
                    ans.append(stack.pop());
                }
                stack.push(ch);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)";
        infix = "(a+b)*(c+d)";
        infix = "(a+b)^(c*d)/e^f^g";
        infix = "a/b/c/d";
        System.out.println("Postfix : " + infixToPostfix(infix));
    }
}
