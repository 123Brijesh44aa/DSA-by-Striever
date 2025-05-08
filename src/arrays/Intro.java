package arrays;

import java.util.ArrayList;
import java.util.Arrays;

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
    }
}
