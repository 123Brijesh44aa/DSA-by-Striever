import java.util.Stack;

public class PostfixToPrefix {
    private static boolean isOperand(char ch){
        return (
                ch >= 'A' && ch <= 'Z' ||
                        ch >= 'a' && ch <= 'z' ||
                        ch >= '0' && ch <= '9'
        );
    }

    private static String postfixToPrefix(String string){
        int i = 0;
        Stack<String> stack = new Stack<>();
        while (i < string.length()){
            char ch = string.charAt(i);
            if (isOperand(ch)){
                stack.push(String.valueOf(ch));
            }
            else {
                String t1 = stack.pop();
                String t2 = stack.pop();
                String newStr = (ch+t2+t1);
                stack.push(newStr);
            }
            i++;
        }
        return stack.peek();
    }
    public static void main(String[] args) {
        String string = "ab-de+f*/";
        System.out.println("Prefix expression of postfix is : "+postfixToPrefix(string));
    }
}
