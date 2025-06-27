package dp;

public class ZeroOneKnapSack {

    // Problem Statement:
// Given a set of items, each with a weight and a value, and a knapsack with a fixed capacity,
// determine the maximum total value that can be obtained by selecting a subset of the items
// such that the total weight does not exceed the knapsack's capacity.
//
// Input:
// - int[] weight: an array where weight[i] is the weight of the i-th item
// - int[] value: an array where value[i] is the value of the i-th item
// - int capacity: the maximum weight the knapsack can carry
//
// Constraint:
// - Each item can be included at most once (0/1 property).
//
// Goal:
// - Select items to maximize the total value without exceeding the knapsack's capacity.

    private static int maxProfit(int[] weight, int[] value, int w, int n) {
        // w - capacity // n - length of wt[] and val[]
        if (n == 0 || w == 0){
            return 0;
        }
        if (weight[n-1] > w){
            return maxProfit(weight,value,w,n-1);
        } else { // (weight[n - 1] <= w)
            return Math.max(
                    value[n-1] + maxProfit(weight,value,w-weight[n-1], n-1),
                    maxProfit(weight,value,w,n-1)
            );
        }
    }

    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int w = 7;
        int n = wt.length;
        System.out.println("max profit is : "+ maxProfit(wt,val,w,n));
    }
}
