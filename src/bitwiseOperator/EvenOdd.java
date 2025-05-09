package bitwiseOperator;

public class EvenOdd {

    static boolean isEven(int num){
        if ( (num & 1) == 0){  // even number's LSB always 0 and odd's 1
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isEven(50));
    }
}
