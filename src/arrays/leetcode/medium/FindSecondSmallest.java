package arrays.leetcode.medium;

public class FindSecondSmallest {

    private static int findSecondSmallest(int[]arr){
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        if (arr.length < 2){
            return -1;
        }
        for (int num: arr){
            if (num < smallest){
                secondSmallest = smallest;
                smallest = num;
            }
            else if (num > smallest && num < secondSmallest){
                secondSmallest = num;
            }
        }
        if (secondSmallest == Integer.MAX_VALUE){
            // this condition means all elements were same and second smallest never updated
            return -1;
        }
        return secondSmallest;
    }

    public static void main(String[] args) {
        int[]arr = {-1,1,-10,-11};
        System.out.println(findSecondSmallest(arr));
    }
}
