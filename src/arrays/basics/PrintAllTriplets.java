package arrays.basics;

public class PrintAllTriplets {

    static void printTriplets(int[]arr){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                for (int k=0; k<arr.length; k++){
                    System.out.print(" ("+arr[i]+","+arr[j]+","+arr[k]+"), ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3};
        printTriplets(arr);
    }
}
