package arrays.basics;

public class AllPairs {

    static void allPairs(int[]arr){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                System.out.print("("+arr[i]+","+arr[j]+"), ");
            }
        }
    }

    public static void main(String[] args) {
        int[]arr = {10,20,30};
        allPairs(arr);
    }
}
