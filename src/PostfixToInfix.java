import java.util.Stack;

public class PostfixToInfix {

    private static boolean isOperand(char ch){
        return (ch >= 'A' && ch <= 'Z' ||
                        ch >= 'a' && ch <= 'z' ||
                        ch >= '0' && ch <= '9'
        );
    }

    private static String postfixToInfix(String string){
        int i = 0;
        Stack<String> stack = new Stack<>();
        while (i < string.length()){
            char ch = string.charAt(i);
            if (isOperand(ch)){
                stack.push(String.valueOf(ch));
            } else {
                String t1 = stack.pop();
                String t2 = stack.pop();
                String newString = "("+t2+ch+t1+")";
                stack.push(newString);
            }
            i++;
        }
        return stack.peek();
    }
    public static void main(String[] args) {
        String post = "AB-DE+F*/";
        System.out.println("Infix Expression is : "+postfixToInfix(post));
    }
}
