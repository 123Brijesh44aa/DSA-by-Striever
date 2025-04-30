package recursions.basics;

public class RecursiveSum {

    int recursiveSum(int n){
        if(n == 0){
            return 0;
        }
        return n + recursiveSum(n-1);
    }

    public static void main(String[] args) {
        RecursiveSum rs = new RecursiveSum();
        System.out.println(rs.recursiveSum(3));
    }
}