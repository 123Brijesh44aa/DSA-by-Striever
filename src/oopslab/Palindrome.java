package oopslab;

public class Palindrome {
    private static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s == "") {
            return false;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                return true;
            }
            i++;
            j--;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcba";
        s = "abcd";
        System.out.println("is Palindrome : " + isPalindrome(s));
    }
}
