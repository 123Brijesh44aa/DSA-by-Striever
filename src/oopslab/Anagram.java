package oopslab;

public class Anagram {
    private static boolean isAnagram(String a, String b) {
        int[] ana = new int[26];
        for (int i = 0; i < a.length(); i++) {
            ana[a.charAt(i) - 'a']++;
            ana[b.charAt(i) - 'a']--;
        }
        for (int i : ana) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String a = "brijesh";
        String b = "rbjishe";
        System.out.println("is valid anagram : " + isAnagram(a, b));
    }
}
