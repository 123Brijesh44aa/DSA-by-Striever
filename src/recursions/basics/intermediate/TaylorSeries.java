package recursions.basics.intermediate;


class HornersRule{
    // Taylor's Series using Horner's Rule (Faster than previous because it reduces the number of multiplications)
    // e^x = 1+x[1+x/2[1+x/3[1+x/4]]]
    static double s = 1;
    double e(int x, int n){
        if (n==0){
            return s;
        }
        s = 1+ (double) x /n*s;
        e(x,n-1);
        return s;
    }
}

// e^x = 1+x+x^2/2!+x^3/3!+x^4/4!+.......+n terms
public class TaylorSeries {

    static double p = 1.0;
    static double f = 1.0;
    double e(int x, int n){
        double result;
        if (n == 0){
            return (1);
        }
        else {
            result = e(x, n-1);
            p = p*x;
            f = f*n;
            return (result + p/f);
        }
    }

    // Taylor Series using for loop
    double e_for(int x, int n){
        double s = 1;
        for (;n>0;n--){
            s = 1+ (double) x /n*s;
        }
        return s;
    }


    public static void main(String[] args) {
        TaylorSeries taylorSeries = new TaylorSeries();
        double e = taylorSeries.e(3,10);
        System.out.println(e);

        double e_for = taylorSeries.e_for(3,10);
        System.out.println("using for loop : "+e_for);

        HornersRule hornersRule = new HornersRule();
        double e2 = hornersRule.e(3,10);
        System.out.println("using horners rule : "+ e2);
    }
}
