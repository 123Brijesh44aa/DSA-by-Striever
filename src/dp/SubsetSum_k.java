package dp;

public class SubsetSum_k {

    // Problem Statement:
    // Given an array of integers and a target sum, determine if there exists a subset of the array
    // whose elements add up exactly to the target sum. Return true if such a subset exists, otherwise return false.

    // using recursion
    private static boolean subsetSum(int[] arr, int sum, int n){
        if (sum == 0 && n == 0){
            return true;
        }
        if (sum == 0 && n > 0){
            return true;
        }
        if (sum > 0 && n == 0){
            return false;
        }

        if (arr[n-1] <= sum){ // we have 2 choices here : 1. choose element or 2. not choose
            return ( subsetSum(arr, sum-arr[n-1], n-1) || subsetSum(arr, sum, n-1) );
        } else {
            return subsetSum(arr,sum,n-1);
        }
    }

    // memoization
    private static boolean helper(int[] arr, int sum, int n, Boolean[][] dp){
        if (sum == 0 && n == 0){
            return true;
        }
        if (sum == 0 && n > 0){
            return true;
        }
        if (sum > 0 && n == 0 ){
            return false;
        }
        if (dp[n][sum] != null){
            return dp[n][sum];
        }
        if (arr[n-1] <= sum){
            dp[n][sum] = ( helper(arr, sum-arr[n-1], n-1, dp) || helper(arr, sum, n-1, dp) );
        } else {
            dp[n][sum] = helper(arr,sum,n-1,dp);
        }
        return dp[n][sum];
    }
    private static boolean subsetSum_memo(int[] arr, int sum , int n){
        Boolean[][] dp = new Boolean[n+1][sum+1];
        return helper(arr,sum,n,dp);
    }


    // bottom up
    private static boolean subsetSum_optimal(int[] arr, int sum){
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i<n+1; i++){
            for (int j = 0; j<sum+1; j++){
                if (j == 0 && i == 0) dp[i][j] = true;
                if (j == 0 && i>0) dp[i][j] = true;
                if (j > 0 && i == 0) dp[i][j] = false;
            }
        }
        for (int i = 1; i<n+1; i++){
            for (int j = 1; j<sum+1; j++){
                if (arr[i-1] <= sum){
                    // choose or not choose
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int n = arr.length;
        int sum = 14;
        System.out.println("subset sum present : "+subsetSum(arr,sum,n));
        System.out.println("subset sum present (memo) : "+subsetSum_memo(arr,sum,n));
    }
}
