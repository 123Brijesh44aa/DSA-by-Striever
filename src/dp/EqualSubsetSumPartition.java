package dp;

public class EqualSubsetSumPartition {

    // problem statement:
    // in this problem we have to  return true if a given set of integers can be divided
    // into two subsets with equal sums else false.

    // Example :
    // arr = [1,5,11,5]
    // o/p = true

    // Explanation :
    // subset1 = [1,5,5] , subset2 = [11]
    // sum1 = sum of elements of subset1 = 1+5+5 = 11
    // sum2 = sum of elements of subset2 = 11
    // sum1 == sum2 -> return true

    // Problem-Solving Technique :
    // 1. understand problem statement
    // 2. find similarity OR identify type ( like 0/1 knapsack, subset sum )
    // 3. code variations

    // Approach :
    // if both partitions sums are equal to the total sum the total sum becomes an even number.
    // e.g. partition1 = {1,5,5} partition2 = {11}
    // sum1 = 11 sum2 = 11
    // totalSum = sum1+sum2 OR S2
    // we can see that the total sum is multiple of 2 ( which makes totalSum an even number )
    // observation1 -> if total sum is odd -> we simply return false
    // observation2 -> if total sum is even -> we have to find only one subset whose sum is equal to ( totalSum/2 ) -> which makes this problem similar to "Subset Sum problem".
    // so now our goal is to find the subset whose sum is 11 ( similar to subset sum problem )

    private static boolean subsetSum(int[]arr, int sum){
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i=0; i<n+1; i++){
            for (int j=0; j<sum+1; j++){
                if (i==0 && j==0){
                    dp[i][j] = true;
                }
                if (i>0 && j==0){
                    dp[i][j] = true;
                }
                if (i==0 && j>0){
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    private static boolean equalSubsetSumPartition(int[]arr){
        int totalSum = 0;
        for (int j : arr) {
            totalSum += j;
        }
        if (totalSum % 2 != 0){
            return false;
        }
        return subsetSum(arr,totalSum/2);
    }


    public static void main(String[] args) {

    }
}
