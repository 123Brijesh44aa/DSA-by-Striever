package recursions.basics.intermediate;

public class IndirectRecursion {

    static void funA(int n){
        if (n>0){
            System.out.println(n);
            funB(n-1);
        }
    }

    static void funB(int n){
        if (n>0){
            System.out.println(n);
            funA(n/2);
        }
    }

    public static void main(String[] args) {
        funA(20);
    }
}
