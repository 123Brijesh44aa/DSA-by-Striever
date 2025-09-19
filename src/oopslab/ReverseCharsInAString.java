package oopslab;

public class ReverseCharsInAString {

    // "brijesh" - > "hsejirb"

    private static String reverseChars(String string) {
        if (string == null || string.length() == 0 || string == "") {
            return "";
        }
        char[] charArr = string.toCharArray();
        int i = 0;
        int j = charArr.length - 1;
        while (i < j) {
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
            i++;
            j--;
        }
        string = "";
        for (int idx = 0; idx < charArr.length; idx++) {
            string = string + charArr[idx];
        }

        return string;
    }

    public static void main(String[] args) {
        String string = "brijesh";
        System.out.println("reversed String is : " + reverseChars(string));
    }
}
