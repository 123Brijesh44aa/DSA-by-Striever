package bitwiseOperator;

public class Intro {


    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        // bitwise OR operator
        int or = a | b;

        // bitwise AND operator
        int and = a & b;

        // bitwise NOT operator
        int not = ~a;

        // bitwise XOR operator
        int xor = 5 ^ 5;

        System.out.println(or);

        System.out.println(and);

        System.out.println(not);

        System.out.println(xor);



        // LEFT SHIFT AND RIGHT SHIFT OPERATOR

        // LEFT Shift operator (<<)
        // shifting bits left side
        // ex: a<<1  -> a to left shift by 1 bit OR multiplying a with 2
        // ex: a<<2 -> a to left shift by 2 bit OR multiplying a with 2^2
        // and so on.
        System.out.println("\nLEFT SHIFT OPERATOR");
        int num = 7;
        int ans = num << 1;
        System.out.println(ans);
        ans = num << 2;
        System.out.println(ans);
        ans = ans << 2;
        System.out.println(ans);

        // RIGHT Shift operator (>>)
        // a>>1 -> dividing a by 2^1;
        // a>>2 -> dividing a by 2^2;
        // a>>3 -> dividing a by 2^3;
        System.out.println("\nRIGHT SHIFT OPERATOR");
        int n = 100;
        int answer = n >> 1;
        System.out.println(answer);
        answer = answer >> 1;
        answer = answer >> 1;
        System.out.println(answer);
        answer = answer >> 2;
        System.out.println(answer);
        answer = answer >> 1;
        System.out.println(answer);

        // by default, all data types are signed in java except char because char is unsigned.

        long y = -100; // signed long (default)
        long answer3 = y >> 1;
        System.out.println(answer3);

        // Right shift operator performs differently with signed and unsigned values
        long x = Integer.toUnsignedLong(-100); //  unsigned
        long answer2 = x >> 1;
        System.out.println(answer2); // 2147483598


        int z = 10;
        System.out.println(z >> -91); // 0
        System.out.println(z << -1); // 0




    }
}
