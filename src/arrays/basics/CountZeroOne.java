package arrays.basics;

import java.util.HashMap;
import java.util.Map;

public class CountZeroOne {

    static Map<String, Integer> countZeroOne(int[] arr) {
        Map<String, Integer> map = new HashMap<>();
        int zero = 0;
        int one = 0;
        for (int i=0; i<arr.length-1; i++){
            if (arr[i] == 0){
                zero++;
            }
            if (arr[i] == 1){
                one++;
            }
        }
        map.put("zero",zero);
        map.put("one", one);
        return map;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0,1,0,4,0,3,4,1,0,1,1,0,0,3,0,5,0,1,4,5,30,0};
        Map<String, Integer> map = countZeroOne(arr);

        System.out.println("total zeros: "+map.get("zero")+" , total ones: "+map.get("one"));
    }
}
