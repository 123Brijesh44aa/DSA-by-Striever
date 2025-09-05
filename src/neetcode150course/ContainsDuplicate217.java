package neetcode150course;

import java.util.HashMap;

public class ContainsDuplicate217 {

    // problem description :

    // given an integer array nums, return true if any value appears at least twice
    // in the
    // array, and return false if every element is distinct

    // brute force
    // will take O(n^2) time

    // optimal
    // using hasmap
    // we can store array elements in hashmap and check if the array contains this
    // element at least twice or not

    private static boolean isContainsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int element : nums) {
            if (!map.containsKey(element)) {
                map.put(element, 1);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
