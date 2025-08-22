import java.util.ArrayList;

public class AsteroidCollision735 {

    // PROBLEM DESCRITPION : LEETCODE 735

    // We are given an array asteroids of integers representing asteroids in a row.
    // The indices of the asteriod in the array represent their relative position in
    // space.

    // For each asteroid, the absolute value represents its size, and the sign
    // represents its direction (positive meaning right, negative meaning left).
    // Each asteroid moves at the same speed.

    // Find out the state of the asteroids after all collisions. If two asteroids
    // meet, the smaller one will explode. If both are the same size, both will
    // explode. Two asteroids moving in the same direction will never meet.

    // Example 1:

    // Input: asteroids = [5,10,-5]
    // Output: [5,10]
    // Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never
    // collide.
    // Example 2:

    // Input: asteroids = [8,-8]
    // Output: []
    // Explanation: The 8 and -8 collide exploding each other.
    // Example 3:

    // Input: asteroids = [10,2,-5]
    // Output: [10]
    // Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide
    // resulting in 10.

    // Constraints:

    // 2 <= asteroids.length <= 104
    // -1000 <= asteroids[i] <= 1000
    // asteroids[i] != 0

    private static int[] asteriodCollision(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                list.addLast(arr[i]);
            } else {
                while (!list.isEmpty() && list.getLast() > 0 && list.getLast() < Math.abs(arr[i])) {
                    list.removeLast();
                }
                if (!list.isEmpty() && list.getLast() == Math.abs(arr[i])) {
                    list.removeLast();
                } else if (list.isEmpty() || list.getLast() < 0) {
                    list.addLast(arr[i]);
                }
            }
        }
        return list.stream().mapToInt((Integer val) -> val).toArray();
    }

    public static void main(String[] args) {

    }
}
