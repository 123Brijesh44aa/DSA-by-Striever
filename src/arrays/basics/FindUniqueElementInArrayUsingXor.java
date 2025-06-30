package arrays.basics;

public class FindUniqueElementInArrayUsingXor {

    static int findUnique(int[]arr){
        int unique = 0;
        for (int i=0; i<arr.length; i++){
            unique = unique ^ arr[i];
        }
        return unique;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,1,3,7,3,5,2,7};
        System.out.println("Unique Element is : "+findUnique(arr));
    }
}
