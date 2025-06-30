package recursions.basics.intermediate;

public class Power {

    static int pow(int m, int n) {  // m->number, n->power
        if (n==0){
            return 1;
        }
        return pow(m, n-1) * m;
    }

    // optimized version
    static int pow_optimized(int m, int n){
        if (n==0){
            return 1;
        }
        if (n%2==0){
            return pow(m*m, n/2);
        }
        else {
            return m*pow(m*m, n/2);
        }
    }

    // power using for loop
    static int pow_for(int m, int n){
        int p = 1;
        for (int i=1; i<=n; i++){
            p = p*m;
        }
        return p;
    }

    public static void main(String[] args){
        System.out.println(pow(2,10));
        System.out.println(pow_optimized(2,10));
        System.out.println(pow_for(2, 9));
    }
}
