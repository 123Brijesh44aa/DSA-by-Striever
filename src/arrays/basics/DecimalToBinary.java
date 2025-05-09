package arrays.basics;

public class DecimalToBinary {

    static int decimalToBinary(int number){
        StringBuilder binary = new StringBuilder();
        while (number>0){
            int remainder = number%2;
            binary.insert(0, remainder);
            number /= 2;
        }
        return Integer.parseInt(String.valueOf(binary));
    }

    static int binaryToDecimal(String binary){
        int sum = 0;
        int j = 0;
        for (int i=binary.length()-1; i>=0; i--){
            if (binary.charAt(i) != '1' && binary.charAt(i) != '0') {
               return -1;
            }
            sum = (int) (sum + (binary.charAt(j) - '0') * Math.pow(2, i));
            j++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(170));
        System.out.println(binaryToDecimal("10910"));
    }
}
