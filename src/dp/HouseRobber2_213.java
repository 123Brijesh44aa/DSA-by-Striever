package dp;

import java.util.Arrays;

class HouseRobber2_213 {

    // this problems is similar to the HouseRobber 1, the only difference is that
    // here All the houses at this place are arranged in a circle.
    // that means the first house is the neighbour(adjacent) of the last house.

    // ip = 2,3,2
    // op = 3 -> you cannot rob house 1(money=2) and then rob house 3(money=2) ,
    // because they are adjacent house.

    // ip = 1,2,3,1
    // op = 4

    // ip = 1,2,3
    // op = 3

    private int helper(int[] nums) {
        int n = nums.length;
        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    private int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] cp1WithoutFirst = new int[nums.length - 1];
        System.arraycopy(nums, 1, cp1WithoutFirst, 0, nums.length - 1);
        int[] cp2WithoutLast = new int[nums.length - 1];
        System.arraycopy(nums, 0, cp2WithoutLast, 0, nums.length - 1);
        int ans1 = helper(cp1WithoutFirst);
        int ans2 = helper(cp2WithoutLast);
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 2 };
        System.out.println("rob 2 max is : " + new HouseRobber2_213().rob2(arr));
        arr = new int[] { 1, 2, 3, 1 };
        System.out.println("rob 2 max is : " + new HouseRobber2_213().rob2(arr));
        arr = new int[] { 1, 2, 3 };
        System.out.println("rob 2 max is : " + new HouseRobber2_213().rob2(arr));

    }
}