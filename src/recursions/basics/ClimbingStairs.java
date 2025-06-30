package recursions.basics;

import java.util.ArrayList;

public class ClimbingStairs {

    // Climbing Stairs: Print All
    static void printAllWays(int remaining, ArrayList<Integer> path){
        if (remaining == 0){
            System.out.println(path);
            return;
        }
        if (remaining < 0){
            return;
        }

        // take step 1
        path.add(1);
        printAllWays(remaining-1, path);
        path.removeLast();

        // take step 2
        path.add(2);
        printAllWays(remaining-2, path);
        path.removeLast();
    }

    // Climbing Stairs: Print One
    static boolean printOne(int remaining, ArrayList<Integer> path){
        if (remaining == 0){
            System.out.println(path);
            return true;
        }
        if (remaining < 0){
            return false;
        }

        // Take Step 1
        path.add(1);
        if (printOne(remaining-1, path)){
            return true;
        }
        path.removeLast();

        // Take Step 2
        path.add(2);
        if (printOne(remaining-2, path)){
            return true;
        }
        path.removeLast();

        return false;
    }

    static int countAll(int remaining){
        if (remaining < 0){
            return 0;
        }
        if (remaining == 0){
            return 1;
        }

        int step1 = countAll(remaining-1);
        int step2 = countAll(remaining-2);

        return step1 + step2;
    }

    public static void main(String[] args) {
        printAllWays(5,new ArrayList<>());
        System.out.println();
        printOne(5, new ArrayList<>());
        System.out.println();
        int c = countAll(5);
        System.out.println("count: "+c);
    }
}
