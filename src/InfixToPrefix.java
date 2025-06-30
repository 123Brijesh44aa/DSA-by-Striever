import java.util.Stack;

public class InfixToPrefix {

    private static String reverse(String string){
        String reversed = "";
        for (int i=string.length()-1; i>=0; i--){
            char ch = string.charAt(i);
            if (ch == ' '){
                continue;
            }
            else if (ch == '('){
                reversed += ')';
            }
            else if (ch == ')'){
                reversed += '(';
            }
            else {
                reversed += ch;
            }
        }
        return reversed;
    }

    private static int priority(char operator){
        return switch (operator){
            case '+','-' -> 1;
            case '*','/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    private static boolean isOperand(char ch){
        return (
                ch >= 'A' && ch <= 'Z' ||
                ch >= 'a' && ch <= 'z' ||
                ch >= '0' && ch <= '9'
        );
    }

    private static String infixToPrefix(String infix){
        infix = reverse(infix);
        int i = 0;
        String ans = "";
        Stack<Character> stack = new Stack<>();
        while (i < infix.length()){
            char ch = infix.charAt(i);
            if (isOperand(ch)){
                ans += ch;
            }else if (ch == '('){
                stack.push(ch);
            } else if (ch == ')'){
                while (!stack.isEmpty() && stack.peek() != '('){
                    ans += stack.pop();
                }
                stack.pop(); // pop '('
            }
            else {
                if (ch == '^'){
                    while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())){
                        ans += stack.pop();
                    }
                } else {
                    while (!stack.isEmpty() && priority(ch) < priority(stack.peek())){
                        ans += stack.pop();
                    }
                }
                stack.push(ch);
            }
            i++;
        }
        while (!stack.isEmpty()){
            ans += stack.pop();
        }
        return reverse(ans);
    }

    public static void main(String[] args) {
        String s = "(A+B)*C-D+F";
        System.out.println("Prefix expression : "+infixToPrefix(s));
    }
}
