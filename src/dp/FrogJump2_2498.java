package dp;

public class FrogJump2_2498 {

    private int maxJump(int[] stones) {
        int n = stones.length;
        if (n < 3) {
            return (stones[1] - stones[0]);
        }
        int minJump = Integer.MIN_VALUE;
        for (int i = 1; i < n - 1; i++) {
            minJump = Math.max(minJump, (stones[i + 1] - stones[i - 1]));
        }
        return minJump;

    }

    public static void main(String[] args) {
        int[] stones = { 0, 2, 5, 6, 7 };
        System.out.println("max jump is : " + new FrogJump2_2498().maxJump(stones));
    }
}
