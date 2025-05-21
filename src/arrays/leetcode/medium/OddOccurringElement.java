package arrays.leetcode.medium;

public class OddOccurringElement {

    private static int oddOccurringElement(int[]arr){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid = start + (end-start)/2;
        while (start <= end){
            //single element
            if (start == end){
                return start;
            }
            //mid-check -> even or odd
            if ((mid & 1) == 1){ // mid & 1 -> true -> odd
                if (arr[mid-1] == arr[mid]){
                    //right
                    start = mid + 1;
                }
                else {
                    //left
                    end = mid -1;
                }
            }
            else { // even
                if (arr[mid] == arr[mid+1]){
                    //right
                    start = mid + 2;
                }
                else {
                    // ya to me right pe khada hu
                    // ya to me answer pe khada hu
                    // kyoki e = mid -1; se answer lost ho sakta ha
                    end = mid;
                }
            }
            mid = start + (end-start)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]arr = {2,2,3,3,4,4,2,1,1};
        arr = new int[]{2,2,0};
        System.out.println(oddOccurringElement(arr));
    }
}
