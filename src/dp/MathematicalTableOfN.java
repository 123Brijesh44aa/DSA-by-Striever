package dp;

public class MathematicalTableOfN {

    private static void table(int n, int length){
        if (length == 0){
            return;
        }
        if (n <= 0){
            return;
        }
        table(n, length-1);
        System.out.println( length+" x "+n+" = "+(n*length) );
    }

    public static void main(String[] args) {
        int n = 7;
        int length = 100;
        table(n,length);
    }
}
