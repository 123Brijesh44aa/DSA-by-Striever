package dp;

public class MaxSubStringLength {

    // Problem:
    // find the length of longest substring of a given string of digits,
    // such that the sum of digits in the first half and second half of the substring is the same.
    // Ex: [i/p - "142124" o/p - 6], 1+4+2 = 1+2+4
    // Ex: [i/p - "9430723" o/p - 4], "4307"

    private static int maxSubStringLength(String string){
        int n = string.length();
        int max = 0;
        for (int i=0; i<n; i++){
            StringBuilder substring = new StringBuilder();
            for (int j=i; j<n; j++){
                substring.append(string.charAt(j));
                int len = substring.length();
                if (len%2 == 0){
                    if (len > max) {
                        int half = len/2;
                        int leftSum = 0;
                        int rightSum = 0;
                        for (int k=0; k<half; k++) {
                            leftSum += substring.charAt(k) - '0';
                            rightSum += substring.charAt(k+half) - '0';
                        }
                        if (leftSum == rightSum) {
                            System.out.println("substring: "+substring);
                            max = len;
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String string = "9430723";
        System.out.println("max substring length is : "+maxSubStringLength(string));
        string = "142124";
        System.out.println("max substring length is : "+maxSubStringLength(string));
    }
}
