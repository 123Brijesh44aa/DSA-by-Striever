package recursions.basics.intermediate;

public class TowerOfHanoi {

    static void toh(int n, int a, int b, int c){
        if (n>0){
            toh(n-1, a,c,b);
//            System.out.println("from "+a+" to "+c);
            System.out.print("("+a+","+c+") ");
            toh(n-1, b,a,c);
        }
    }

    public static void main(String[] args) {
        toh(3,1,2,3);
    }
}
