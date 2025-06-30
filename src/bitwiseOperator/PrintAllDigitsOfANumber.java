package bitwiseOperator;

public class PrintAllDigitsOfANumber {

    static void printAllDigitsOfaNumber(int n){
        String str = String.valueOf(n);
        for (int i=0; i<str.length(); i++){
            System.out.print(str.charAt(i)+", ");
        }
    }

    static void printR(int n){
        if (n<0){
            System.out.println(n);
        }
        if (n>0){
            printR(n/10);
            System.out.print(n%10 +" ");
        }
    }

    public static void main(String[] args) {
        printAllDigitsOfaNumber(98767544);
        System.out.println();
        printR(135792468);
    }
}
