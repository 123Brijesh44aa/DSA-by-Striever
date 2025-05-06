package recursions.basics.intermediate;

public class Combinations {

    static int fact(int n){
        if (n==0){
            return 1;
        }
        return fact(n-1)*n;
    }

    // combination ( nCr ) using factorial formula
    // nCr = n!/(r!*(n-r)!)
    static int combination(int n, int r){
        int fon = fact(n); // factorial of n
        int fo_r = fact(r); // factorial of r
        int fnmr = fact(n-r); // factorial of (n-r)
        return fon/(fo_r*fnmr);
    }

    // Using Pascal's Triangle
    static int combination_pascal_triangle(int n, int r){
        if (r==0 || n==r){
            return 1;
        }
        return combination_pascal_triangle(n-1, r-1) + combination_pascal_triangle(n-1,r);
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(combination(9,5));
        System.out.println(combination(10,2));
        System.out.println(combination_pascal_triangle(9,5));
        System.out.println(combination_pascal_triangle(10,2));
    }
}
