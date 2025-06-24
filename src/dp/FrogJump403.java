package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrogJump403 {

    Map<Integer,Integer> map = new HashMap<>(); // map(stone,index)
    int[][] dp;

    private boolean solve(int i, int k, int[] stones){
        if (i == stones.length - 1){
            return true;
        }

        if (dp[i][k] != -1){
            return dp[i][k] == 1;
        }

        boolean k_ = false;  // k
        boolean km = false;  // k-1
        boolean kp = false;  // k+1

        // try jump k
        if (map.containsKey(stones[i]+k)){
            k_ = solve(map.get(stones[i]+k), k, stones);
        }
        // try jump (k-1)
        if (k>1 && map.containsKey(stones[i]+k-1)){
            km = solve(map.get(stones[i]+k-1), k-1, stones);
        }
        // try jump (k+1)
        if (map.containsKey(stones[i]+k+1)){
            kp = solve(map.get(stones[i]+k+1), k+1, stones);
        }

        dp[i][k] = (k_ || km || kp) ? 1 : 0;

        return dp[i][k] == 1;

    }

    private boolean canCross(int[] stones){
        if (stones[1] - stones[0] != 1){
            return false;
        }
        for (int i=0; i<stones.length; i++){
            map.put(stones[i], i);
        }
        dp = new int[stones.length][stones.length];
        for (int[] row: dp){
            Arrays.fill(row, -1);
        }
        return solve(1,1,stones);
    }

    public static void main(String[] args) {

    }
}
