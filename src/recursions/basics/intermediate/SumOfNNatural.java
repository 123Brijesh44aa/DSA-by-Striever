package recursions.basics.intermediate;

public class SumOfNNatural {

    // using recursion
    static int sum(int n){
        if (n==0){
            return 0;
        }
        else {
            return sum(n-1) + n;
        }
    }

    // using formula
    static int sum2(int n){
        return (n*(n+1))/2;
    }

    // using for loop
    static int sum3(int n){
        int s = 0;
        for (int i=0; i<=n; i++){
            s += i;
        }
        return s;
    }

    public static void main(String[] args){
        System.out.println(sum(5));
        System.out.println(sum2(5));
        System.out.println(sum3(5));
    }
}
