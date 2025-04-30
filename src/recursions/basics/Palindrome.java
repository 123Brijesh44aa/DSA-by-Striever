package recursions.basics;

public class Palindrome {

    void reverseCharArray(char[] chars, int start){
        if (start >= (chars.length/2) ){
            return;
        }
        char temp = chars[start];
        chars[start] = chars[(chars.length - start - 1)];
        chars[(chars.length - start - 1)] = temp;

        reverseCharArray(chars, start+1);
    }

    String reverseString(String str){
        char[] chars = str.toCharArray();
        reverseCharArray(chars, 0);
        return String.valueOf(chars);
    }

    boolean isPalindrome(String str){
        return str.equals(reverseString(str));
    }


    // another better approach
    boolean isPalindromeOptimized(String str, int start){
        if (start >= str.length()/2){
            return true;
        }
        if (str.charAt(start) != str.charAt((str.length() - start - 1))){
            return false;
        }
        return isPalindromeOptimized(str, start+1);
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String radar = "CIVIC,RADAR,LEVEL,RADAR,CIVIC";
        System.out.println(palindrome.isPalindrome(radar));

        System.err.println(palindrome.isPalindromeOptimized(radar,0));
    }
}
