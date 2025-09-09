package neetcode150course;

import java.util.Arrays;

public class EncodeDecodeStrings271 {

    // problem Description :
    // Given an array of strings s[], you are required to create an algorithm in the
    // encode() function that can convert the given strings into a single encoded
    // string, which can be transmitted over the network and then decoded back into
    // the original array of strings. The decoding will happen in the decode()
    // function.

    // You need to implement two functions:
    // 1. encode(): This takes an array of strings s[] and encodes it into a single
    // string.
    // 2. decode(): This takes the encoded string as input and returns an array of
    // strings containing the original array as given in the encode method.

    // Note: You are not allowed to use any inbuilt serialize method.

    // Examples:

    // Input: s = ["Hello","World"]
    // Output: ["Hello","World"]
    // Explanation: The encode() function will have the str as input, it will be
    // encoded by one machine. Then another machine will receive the encoded string
    // as the input parameter and then will decode it to its original form.
    // Input: s = ["abc","!@"]
    // Output: ["abc","!@"]
    // Explanation: The encode() function will have the str as input, here there are
    // two strings, one is "abc" and the other one has some special characters. It
    // will be encoded by one machine. Then another machine will receive the encoded
    // string as the input parameter and then will decode it to its original form.
    // Constraints:
    // 1<=s.size()<=100
    // 1<=s[i].size()<=100
    // s[i] contains any possible characters out of the 256 ASCII characters.

    private static String encode(String[] strs) {
        if (strs.length == 0) {
            return Character.toString((char) 258);
        }

        String separator = Character.toString((char) 257);

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append(separator);
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();

    }

    private static String[] decode(String s) {
        if (s.equals(Character.toString((char) 258))) {
            return new String[] {};
        }
        String separator = Character.toString((char) 257);
        return s.split(separator);
    }

    public static void main(String[] args) {
        String[] strs = { "ab", "b", "c", "abc", "bbc", "cbb", "lkdl", "ureifj", "difdfdji" };
        String encodedString = encode(strs);
        System.out.println("Encoded String : " + encodedString);
        System.out.println("Decoded Strings are : " + Arrays.toString(decode(encodedString)));
    }
}
