package recursions.basics;

public class Intro {

    int count = 0;

    void print(){
        if (count == 5){
            return;
        }
        System.out.println(count);
        count++;
        print();
    }

    public static void main(String[] args) {
        System.out.println("Hello recursion");

        Intro intro = new Intro();
        intro.print();

        System.out.println("who are you?");
    }
}




















