package dp;

import java.util.Arrays;

/*
 * Matrix Chain Multiplication Problem Statement
 */

// Problem:
// Given a sequence of matrices, find the most efficient way to multiply these matrices.
// The problem is not to actually perform the multiplications, but merely to decide
// the order in which to perform the multiplications to minimize the total number
// of scalar multiplications.

// Why is the order important?
// Matrix multiplication is associative, meaning that for matrices A, B, and C,
// (AB)C = A(BC). However, the number of scalar multiplications required can vary
// greatly depending on the order of parenthesization. Our goal is to minimize this
// total number of scalar multiplications.

// Constraints:
// - We are given a sequence of matrices A_1, A_2, ..., A_n.
// - For each matrix A_i, its dimensions are p_(i-1) x p_i.
//   This means matrix A_1 has dimensions p_0 x p_1, A_2 has dimensions p_1 x p_2,
//   and so on, up to A_n which has dimensions p_(n-1) x p_n.
// - To multiply two matrices A (m x n) and B (n x p), the number of scalar
//   multiplications required is m * n * p. The resulting matrix will have
//   dimensions m x p.

/*
 * Example:
 * Consider three matrices A_1, A_2, A_3 with the following dimensions:
 * - A_1: 10 x 30
 * - A_2: 30 x 5
 * - A_3: 5 x 60
 */

// From this, our dimension sequence P would be P = [10, 30, 5, 60].
// Here, p_0 = 10, p_1 = 30, p_2 = 5, p_3 = 60.

// We need to find the optimal way to parenthesize the product A_1A_2A_3.

/*
 * Possible Parenthesizations and their Costs:
 */

// 1. Parenthesization: (A_1A_2)A_3
//    - Step 1: Calculate A_1A_2
//        - Dimensions of A_1: 10 x 30
//        - Dimensions of A_2: 30 x 5
//        - Cost of A_1A_2: 10 * 30 * 5 = 1500 scalar multiplications.
//        - Resulting matrix (A_1A_2) will have dimensions 10 x 5.
//    - Step 2: Calculate (A_1A_2)A_3
//        - Dimensions of (A_1A_2): 10 x 5
//        - Dimensions of A_3: 5 x 60
//        - Cost of (A_1A_2)A_3: 10 * 5 * 60 = 3000 scalar multiplications.
//    - Total Cost for (A_1A_2)A_3: 1500 + 3000 = 4500 scalar multiplications.

// 2. Parenthesization: A_1(A_2A_3)
//    - Step 1: Calculate A_2A_3
//        - Dimensions of A_2: 30 x 5
//        - Dimensions of A_3: 5 x 60
//        - Cost of A_2A_3: 30 * 5 * 60 = 9000 scalar multiplications.
//        - Resulting matrix (A_2A_3) will have dimensions 30 x 60.
//    - Step 2: Calculate A_1(A_2A_3)
//        - Dimensions of A_1: 10 x 30
//        - Dimensions of (A_2A_3): 30 x 60
//        - Cost of A_1(A_2A_3): 10 * 30 * 60 = 18000 scalar multiplications.
//    - Total Cost for A_1(A_2A_3): 9000 + 18000 = 27000 scalar multiplications.

/*
 * Input and Output Example:
 */

// Input:
// A sequence of matrix dimensions represented as an array 'p' where p[i-1] and p[i]
// are the dimensions of the i-th matrix.

// For the example above:
// int[] p = {10, 30, 5, 60};

// - A_1: p_0 x p_1 = 10 x 30
// - A_2: p_1 x p_2 = 30 x 5
// - A_3: p_2 x p_3 = 5 x 60

// Output:
// The minimum number of scalar multiplications required to multiply the given
// chain of matrices.

// For the example above:
// Output: 4500

public class MatrixChainMultiplication {

    // Recursive
    private static int mcm(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int tempAns = mcm(arr, i, k) + mcm(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            if (tempAns < minCost) {
                minCost = tempAns;
            }
        }
        return minCost;
    }

    // Memoization
    private static int helper(int[] arr, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int tempAns = helper(arr, i, k, dp) + helper(arr, k + 1, j, dp) + (arr[i - 1] * arr[k] * arr[j]);
            if (tempAns < minCost) {
                minCost = tempAns;
            }
        }
        return dp[i][j] = minCost;
    }

    private static int mcm_memo(int[] arr, int i, int j) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(arr, i, j, dp);
    }

    public static void main(String[] args) {

        int[] arr = { 40, 20, 30, 10, 30 };
        int n = arr.length;
        System.out.println("minimum cost is : " + mcm(arr, 1, n - 1));
        System.out.println("minimum cost is (memo) : " + mcm_memo(arr, 1, n - 1));

    }
}
