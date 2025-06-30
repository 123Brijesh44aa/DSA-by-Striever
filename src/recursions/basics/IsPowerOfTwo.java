package recursions.basics;

public class IsPowerOfTwo {

    static boolean isPowerOfTwo(int n){
        if (n==1){
            return true;
        }
        if (n<=0 || n%2 != 0){
            return false;
        }
        return isPowerOfTwo(n/2);
    }

    static boolean isPowerOfTwo_optimized(int n){
        if (n<=0){return false; }
        return Integer.bitCount(n) == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo_optimized(1024));
    }
}
