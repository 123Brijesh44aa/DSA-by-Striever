
import java.util.HashSet;

public class ValidSudoku36 {

    // problem statement :

    // Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
    // validated according to the following rules:

    // Each row must contain the digits 1-9 without repetition.
    // Each column must contain the digits 1-9 without repetition.
    // Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
    // without repetition.
    // Note:

    // A Sudoku board (partially filled) could be valid but is not necessarily
    // solvable.
    // Only the filled cells need to be validated according to the mentioned rules.

    // Example 1:

    // Input: board =
    // [["5","3",".",".","7",".",".",".","."]
    // ,["6",".",".","1","9","5",".",".","."]
    // ,[".","9","8",".",".",".",".","6","."]
    // ,["8",".",".",".","6",".",".",".","3"]
    // ,["4",".",".","8",".","3",".",".","1"]
    // ,["7",".",".",".","2",".",".",".","6"]
    // ,[".","6",".",".",".",".","2","8","."]
    // ,[".",".",".","4","1","9",".",".","5"]
    // ,[".",".",".",".","8",".",".","7","9"]]
    // Output: true
    // Example 2:

    // Input: board =
    // [["8","3",".",".","7",".",".",".","."]
    // ,["6",".",".","1","9","5",".",".","."]
    // ,[".","9","8",".",".",".",".","6","."]
    // ,["8",".",".",".","6",".",".",".","3"]
    // ,["4",".",".","8",".","3",".",".","1"]
    // ,["7",".",".",".","2",".",".",".","6"]
    // ,[".","6",".",".",".",".","2","8","."]
    // ,[".",".",".","4","1","9",".",".","5"]
    // ,[".",".",".",".","8",".",".","7","9"]]
    // Output: false
    // Explanation: Same as Example 1, except with the 5 in the top left corner
    // being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it
    // is invalid.

    private static boolean isValidSudoku(char[][] board) {
        int n = 9;
        HashSet<Character>[] box = new HashSet[n];
        HashSet<Character>[] row = new HashSet[n];
        HashSet<Character>[] column = new HashSet[n];

        for (int i = 0; i < n; i++) {
            box[i] = new HashSet<Character>();
            row[i] = new HashSet<Character>();
            column[i] = new HashSet<Character>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char val = board[i][j];

                // check for row
                if (val == '.') {
                    continue;
                }
                if (row[i].contains(val)) {
                    return false;
                }
                row[i].add(val);

                // check for column
                if (column[j].contains(val)) {
                    return false;
                }
                column[j].add(val);

                // check for box
                int index = (i / 3) * 3 + (j / 3);
                if (box[index].contains(val)) {
                    return false;
                }
                box[index].add(val);

            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
