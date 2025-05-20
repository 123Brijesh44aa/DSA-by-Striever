package arrays.leetcode.easy;

public class Sqrt69 {

    private static long sqrt(long n){
        long start = 0;
        long end = n;
        long mid;
        long ans = -1;
        while (start <= end){
            mid = start + (end-start)/2;
            long square = mid * mid;
            if (square == n){
                return mid;  // perfect square
            }
            if (square > n){
                // move to the left
                end = mid -1;
            }
            if (square < n){
                // move to the right
                ans = mid;            // store potential answer
                start = mid + 1;
            }
        }
        return ans;
    }

    private static double morePrecision(long n, int precision, long tempSol){
        double factor = 1;
        double ans = tempSol;
        for (int i=0; i<precision; i++){
            factor = factor/10;
            for (double j=ans; j*j < n; j = j+factor){
                ans = j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        long n = 10;
        long res = sqrt(n);
        int precision = 2;
        System.out.println(res);
        double morePrecisionRes = morePrecision(n,precision,res);
        System.out.println(morePrecisionRes);
    }
}
