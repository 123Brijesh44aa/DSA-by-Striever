package bitwiseOperator;

public class PrimeNumber {

    static boolean isPrime(int n){
        if (n<=1){
            return false;
        }
        for (int i=2; i<n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    static void printPrime(int n){ // n -> range ( e.g. n=6  :   1,2,3,4,5,6 )
        for (int i=0; i<=n; i++){
            if (isPrime(i)){
                System.out.print(i+", ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPrime(10));
        printPrime(101);
    }
}
