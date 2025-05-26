package arrays.leetcode.medium;

public class FindSecondLargest {

    private static int findSecondLargest(int[]arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        if (arr.length < 2){
            return -1;
        }
        for (int num: arr){
            if (num > largest){
                secondLargest = largest;
                largest = num;
            }
            else if (num < largest && num > secondLargest){
                secondLargest = num;
            }
        }
        if (secondLargest == Integer.MIN_VALUE){ // this mean all numbers were same and second_last did not updated
            return -1;
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,4,7,7,5};
        arr = new int[]{-3,-5,-9,-1};
        System.out.println(findSecondLargest(arr));
    }
}
