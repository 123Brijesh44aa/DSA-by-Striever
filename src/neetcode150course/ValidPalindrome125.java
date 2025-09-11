public class ValidPalindrome125 {

    // problem description :
    // A phrase is a palindrome if, after converting all uppercase letters into
    // lowercase letters and removing all non-alphanumeric characters, it reads the
    // same forward and backward. Alphanumeric characters include letters and
    // numbers.

    // Given a string s, return true if it is a palindrome, or false otherwise.

    // Example 1:

    // Input: s = "A man, a plan, a canal: Panama"
    // Output: true
    // Explanation: "amanaplanacanalpanama" is a palindrome.
    // Example 2:

    // Input: s = "race a car"
    // Output: false
    // Explanation: "raceacar" is not a palindrome.
    // Example 3:

    // Input: s = " "
    // Output: true
    // Explanation: s is an empty string "" after removing non-alphanumeric
    // characters.
    // Since an empty string reads the same forward and backward, it is a
    // palindrome.

    private static boolean isValidPalindrome(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("is valid Palindrome : " + isValidPalindrome(s));
    }
}
