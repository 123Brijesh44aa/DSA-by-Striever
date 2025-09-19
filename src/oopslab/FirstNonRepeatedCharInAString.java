package oopslab;

public class FirstNonRepeatedCharInAString {
    // example : input = "mmmmmemmm" , output = e

    private static Character firstNonRepeatedCharInAString(String string) {
        if (string == null || string.length() == 0 || string == "") {
            return null;
        }
        for (int i = 0; i < string.length(); i++) {
            boolean found = false;
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j) && i != j) {
                    found = true;
                }
            }
            if (!found) {
                return string.charAt(i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String string = "brijeshbourya";
        System.out.println("non repeated : " + firstNonRepeatedCharInAString(string));
    }
}
