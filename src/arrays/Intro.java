package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Intro {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(Arrays.toString(arr));

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(33);
        arrayList.add(43);
        arrayList.add(899);
        arrayList.add(90);
        arrayList.add(41);

        arrayList.forEach(integer -> {
            System.out.println(integer);
        });

        arr[0] = 44;
        arr[4] = 32;

        arr[arr.length-1] = 40; // inserting at the end
        arr[arr.length/2] = 90; // inserting at the middle of array

        System.out.println(Arrays.toString(arr));

        arrayList.remove(2);


        // Question: input an array and print a sum of its elements
        int[] nums = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Taking input");
        for (int i=0; i<5; i++){
            nums[i] = scanner.nextInt() * 10;
        }
        System.out.println("Printing the Array");
        for (int i=0; i<5; i++){
            System.out.print(nums[i]+", ");
        }
        int sum = 0;
        System.out.println("\nSum of array elements");
        for (int i=0; i<5; i++){
            sum += nums[i];
        }
        System.out.println("Sum : "+ sum);

    }
}
