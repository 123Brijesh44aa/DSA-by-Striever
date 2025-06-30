package arrays.leetcode.medium;

public class DivideTwoIntegers29 {
    private static int divide(int dividend, int divisor){
        // special integer overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        long tempDividend = Math.abs((long)dividend); // -ve -> +ve using .abs function
        long tempDivisor = Math.abs((long)divisor);
        long start = 0;
        long end = tempDividend;
        long mid;
        long ans = -1;
        while (start <= end){
            mid = start + (end-start)/2;
            if (mid*tempDivisor == tempDividend){
                ans = mid;
                break;
            }
            else if (mid*tempDivisor < tempDividend){
                // move to the right
                ans = mid;
                start = mid + 1;
            }
            else {
                // move to the left
                end = mid - 1;
            }
        }
        boolean negative = ( dividend < 0 ) ^ ( divisor < 0 );
        ans = negative ? -ans : ans;
        return (int) ans;
    }
    public static void main(String[] args) {
        int dividend = 3;
        int divisor = -3;
        int result = divide(dividend,divisor);
        System.out.println(result);
    }
}
