package main.java.LeetCode2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2017/10/25.
 */
public class _52_NQueensII {
    //52. N-Queens II (Hard) 47.99%
    public static int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        int cnt = 0;
        return recall(board, cnt, 0);
    }

    public static int recall(char[][] board, int cnt, int row) {
        if (board.length == row) {
            return ++cnt;
        }
        for (int j = 0; j < board.length; j++) {
            if (isValid(board, row, j)) {
                board[row][j] = 'Q';
                cnt = recall(board, cnt, row + 1);
                board[row][j] = '.';
            }
        }
        return cnt;
    }

    public static boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q' && (row + col == i + j || row + j == i + col || col == j)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(5));
    }
}
