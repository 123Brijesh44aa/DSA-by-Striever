package oopslab;

import java.util.Arrays;

public class CountVowelsAndConsonantsInAString {

    private static int[] countVC(String string) {
        if (string == null || string.length() == 0 || string == "") {
            return new int[] { 0, 0 };
        }
        int v = 0;
        int c = 0;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                v++;
            } else {
                c++;
            }
        }
        return new int[] { v, c };
    }

    public static void main(String[] args) {
        String s = "brijeshmourya";
        System.out.println("vowels and consonants are : " + Arrays.toString(countVC(s)));
    }
}
