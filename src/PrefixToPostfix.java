import java.util.Stack;

public class PrefixToPostfix {
    private static boolean isOperand(char ch){
        return (
                ch >= 'A' && ch <= 'Z' ||
                        ch >= 'a' && ch <= 'z' ||
                        ch >= '0' && ch <= '9'
        );
    }

    private static String prefixToPostfix(String string){
        int i = string.length() - 1;
        Stack<String> stack = new Stack<>();
        while (i >= 0){
            char ch = string.charAt(i);
            if (isOperand(ch)) {
                stack.push(String.valueOf(ch));
            }
            else {
                String t1 = stack.pop();
                String t2 = stack.pop();
                String newStr = t1+t2+ch;
                stack.push(newStr);
            }
            i--;
        }
        return stack.peek();
    }
    public static void main(String[] args) {
        String string = "/-AB*+DEF";
        System.out.println("Postfix conversion of prefix is : "+prefixToPostfix(string));
    }
}
