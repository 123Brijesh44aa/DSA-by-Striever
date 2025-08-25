package dp;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionToTrue_BooleanParenthesization {

    /*
     * Problem Statement:
     * Given a boolean expression consisting of the symbols 'T' (true), 'F' (false),
     * and operators '&' (AND), '|' (OR), and '^' (XOR),
     * count the number of ways to parenthesize the expression such that it
     * evaluates to true.
     *
     * Input:
     * - A string S of length N, where S contains only 'T', 'F', '&', '|', and '^'.
     * - The length of S is always odd (operands and operators alternate).
     *
     * Output:
     * - An integer representing the number of ways to parenthesize S so that the
     * value of the expression is true.
     *
     * Example:
     * Input: S = "T|F&T^T"
     * Output: 2
     *
     * Explanation:
     * The two ways to parenthesize "T|F&T^T" to get true are:
     * 1. ((T|F)&(T^T)) => (T|F) = T, (T^T) = F, (T & F) = F
     * 2. (T|(F&T))^T => (F&T) = F, (T|F) = T, (T^T) = F
     *
     * So, there are 2 ways to parenthesize the expression to get true.
     */

    // RECURSION VERSION
    private static int evaluate(String exp, int i, int j, boolean isTrue) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue == true) {
                return exp.charAt(i) == 'T' ? 1 : 0;
            } else {
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }

        int ans = 0;
        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int lt = evaluate(exp, i, k - 1, true);
            int lf = evaluate(exp, i, k - 1, false);
            int rt = evaluate(exp, k + 1, j, true);
            int rf = evaluate(exp, k + 1, j, false);

            if (exp.charAt(k) == '&') {
                if (isTrue == true) {
                    ans += lt * rt;
                } else {
                    ans += lt * rf + lf * rt + lf * rf;
                }
            } else if (exp.charAt(k) == '|') {
                if (isTrue == true) {
                    ans += lt * rt + lt * rf + lf * rt;
                } else {
                    ans += lf * rf;
                }
            } else if (exp.charAt(k) == '^') {
                if (isTrue == true) {
                    ans += lt * rf + lf * rt;
                } else {
                    ans += lt * rt + lf * rf;
                }
            }
        }
        return ans;
    }

    // MEMOIZATION
    private static int helper(
        String exp,
        int i,
        int j,
        boolean isTrue,
        Map<String, Integer> map
    ) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue) {
                return exp.charAt(i) == 'T' ? 1 : 0;
            } else {
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }
        String key = i + "_" + j + "_" + isTrue;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int ans = 0;
        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int lt = helper(exp, i, k - 1, true, map);
            int lf = helper(exp, i, k - 1, false, map);
            int rt = helper(exp, k + 1, j, true, map);
            int rf = helper(exp, k + 1, j, false, map);

            if (exp.charAt(k) == '&') {
                if (isTrue == true) {
                    ans += lt * rt;
                } else {
                    ans += lt * rf + lf * rt + lf * rf;
                }
            } else if (exp.charAt(k) == '|') {
                if (isTrue == true) {
                    ans += lt * rt + lt * rf + lf * rt;
                } else {
                    ans += lf * rf;
                }
            } else if (exp.charAt(k) == '^') {
                if (isTrue == true) {
                    ans += lt * rf + lf * rt;
                } else {
                    ans += lt * rt + lf * rf;
                }
            }
        }

        map.put(key, ans);
        System.out.println(key + " -> " + ans);
        return ans;
    }

    private static int evaluate_memo(String exp, boolean isTrue) {
        int n = exp.length();
        int i = 0;
        int j = n - 1;
        Map<String, Integer> map = new HashMap<>();
        return helper(exp, i, j, isTrue, map);
    }

    public static void main(String[] args) {
        String expression = "T^F&T";
        expression = "T|T&F^T";
        int n = expression.length();
        int i = 0;
        int j = n - 1;
        System.out.println(
            "number of ways to evaluate  the expression to true is : " +
            evaluate(expression, i, j, true)
        );
        System.out.println(
            "number of ways to evaluate  the expression to true(memo) is : " +
            evaluate_memo(expression, true)
        );
    }
}
