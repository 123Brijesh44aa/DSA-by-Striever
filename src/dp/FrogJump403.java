package dp;

import java.util.HashMap;
import java.util.Map;

public class FrogJump403 {

    private static boolean canCross(int[] stones){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<stones.length; i++){
            map.put(stones[i], i);
        }
        int pj = 0;
        int cs = 0;
        for (int i=0; i<stones.length; i++){
            int pjm1 = pj - 1;
            int pj_ = pj;
            int pjp1 = pj+1;
            if ( (map.containsKey(pjm1 + cs) ) ){
                pj = pj+1;
                cs = pjp1+cs;
            }
            if ( (map.containsKey(pj_ + cs)) ){
                // pj will remain pj
                cs = pj_ + cs;
            }
            if ( (map.containsKey(pjm1 + cs)) ){
                pj = pj - 1;
                cs = pjm1 + cs;
            }

            if (cs == stones[stones.length - 1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
