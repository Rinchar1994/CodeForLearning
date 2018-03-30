package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/10/22.
 */
public class _37_SudokuSolver {
    //37. Sudoku Solver (Hard) 1.43%
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    public boolean solve(char[][] board, int pos) {
        if (pos == 81) return true;
        int row = pos / 9, col = pos % 9;
        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                board[row][col] = (char) (i + '0');
                if (_36_ValidSudoku.isValidSudoku(board)) {
                    if (solve(board, pos + 1)) return true;
                }
                board[row][col] = '.';
            }
        } else {
            if (solve(board, pos + 1)) return true;
        }
        return false;
    }
}
