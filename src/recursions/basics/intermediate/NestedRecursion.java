package recursions.basics.intermediate;

public class NestedRecursion {

    static int fun(int n){
        if (n>100){
            return n-10;
        }
        else {
            return fun(fun(n+11));
        }
    }

    public static void main(String[] args){
        int result = fun(95);
        System.out.println(result);
    }
}
