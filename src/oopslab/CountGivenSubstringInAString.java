package oopslab;

public class CountGivenSubstringInAString {

    // ex : "abcabcbbabcbcabc" sub = ab
    // output : 4

    private static int count(String string, String sub) {
        if (string == null || string.length() == 0 || string == "") {
            return 0;
        }
        if (sub == null || sub.length() == 0 || sub == "") {
            return 0;
        }

        int i = 0;
        int j = 0;
        int count = 0;
        while (j < string.length()) {
            if ((j - i + 1) == sub.length()) {
                count += sub.equals(string.substring(i, j + 1)) ? 1 : 0;
                i++;
            }
            j++;
        }

        return count;

    }

    public static void main(String[] args) {
        String string = "abcabcbbabcbcabc";
        String sub = "ab";
        System.out.println("count : " + count(string, sub));
    }
}
