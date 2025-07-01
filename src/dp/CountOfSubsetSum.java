package dp;

public class CountOfSubsetSum{

    // problem statement :
    // count total number of subset sum
    // Example :
    // arr[] = {2,3,5,6,8,10}, sum = 10
    // subsets = [ {2,3,5}, {2,8}, {10} ] => count = 3
    // return 3 else 0

    private static int countSubsetSum(int[] arr, int sum){
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        for (int i=0; i<n+1; i++){
            for (int j=0; j<sum+1; j++){
                if (j==0){
                    dp[i][j] = 1;
                }
                if (i==0 && j>0){
                    dp[i][j] = 0;
                }
            }
        }
        for (int i=1; i<n+1; i++){
            for (int j=1; j<sum+1; j++){
                int count;
                if (arr[i-1] <= j){
                    int include = dp[i-1][j-arr[i-1]];
                    int exclude = dp[i-1][j];
                    count = include+exclude;
                    dp[i][j] = count;
                } else {
                    count = dp[i-1][j]; // we can write it as : int exclude = dp[i-1][j]; count = exclude;
                    dp[i][j] = count;
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[]arr = {2,3,5,6,8,10};
        int sum = 10;
        System.out.println("total number of subset with sum 10 are : "+countSubsetSum(arr,sum));
    }
}
