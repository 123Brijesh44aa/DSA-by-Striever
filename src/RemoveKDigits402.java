import java.util.Stack;

public class RemoveKDigits402 {

    // Problem Description :

    // Given string num representing a non-negative integer num, and an integer k,
    // return the smallest possible integer after removing k digits from num.

    // Example 1:

    // Input: num = "1432219", k = 3
    // Output: "1219"
    // Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
    // which is the smallest.

    // Example 2:

    // Input: num = "10200", k = 1
    // Output: "200"
    // Explanation: Remove the leading 1 and the number is 200. Note that the output
    // must not contain leading zeroes.

    // Example 3:

    // Input: num = "10", k = 2
    // Output: "0"
    // Explanation: Remove all the digits from the number and it is left with
    // nothing which is 0.

    private static String removeKDigits(String s, int k) {
        int n = s.length();
        if (k == n) {
            return "0";
        }
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && k > 0 && s.charAt(i) < stack.charAt(stack.length() - 1)) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(s.charAt(i));
        }
        // what if we are unable to remove k elements : ex: s="123456" =>
        // stack[1,2,3,4,5,6]
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        if (stack.isEmpty()) {
            return "0";
        }

        // here we don't need to reverse the resultant String

        // now remove the zeros from the front
        int nonZeroIndex;
        for (nonZeroIndex = 0; nonZeroIndex < stack.length(); nonZeroIndex++) {
            if (stack.charAt(nonZeroIndex) != '0') {
                break;
            }
        }

        String res = (nonZeroIndex == stack.length() ? "0" : stack.substring(nonZeroIndex));

        return res;
    }

    public static void main(String[] args) {

    }
}
