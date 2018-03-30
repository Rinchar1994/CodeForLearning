package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/10/16.
 */
public class _36_ValidSudoku {
    //36. Valid Sudoku (Medium) 83.33%
    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9], column = new int[9][9], sub = new int[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row[i][board[i][j] - '1'] == 1) {
                        return false;
                    } else {
                        row[i][board[i][j] - '1'] = 1;
                    }
                    if (column[j][board[i][j] - '1'] == 1) {
                        return false;
                    } else {
                        column[j][board[i][j] - '1'] = 1;
                    }
                    if (sub[i / 3 + j / 3 * 3][board[i][j] - '1'] == 1) {
                        return false;
                    } else {
                        sub[i / 3 + j / 3 * 3][board[i][j] - '1'] = 1;
                    }
                }
            }
        }
        return true;
    }
}
