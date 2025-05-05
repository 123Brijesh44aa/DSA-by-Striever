package recursions.basics.intermediate;

public class GlobalAndStaticVariables {

    // Global and Static Variables
    // the static variable will not be created every time when the function is called
    // it is created only one time that is at the loading time of a program.
    // So all the function calls will use this same copy of x { e.g., X=value }

    // this works the same for global variables.

    static int fun(int n){
        if (n>0){
            return fun(n-1)+n;
        }
        return 0;
    }

    static int x=0;
    static int fun_s(int n){
        if (n>0){
            x++;
            return fun_s(n-1)+x;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(fun(5));
        System.out.println(fun_s(5));
    }
}
