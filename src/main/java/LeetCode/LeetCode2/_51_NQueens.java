package main.java.LeetCode.LeetCode2;

import main.java.LeetCode.LeetCodeUtil.TimeCount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2017/10/24.
 */
public class _51_NQueens {
    //51. N-Queens (Hard) 77.05%
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> re = new ArrayList<>();
        recall(board, re, 0);
        return re;
    }

    public static void recall(char[][] board, List<List<String>> re, int row) {
        if (board.length == row) {
            re.add(transform(board));
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isValid(board, row, j)) {
                board[row][j] = 'Q';
                recall(board, re, row + 1);
                board[row][j] = '.';
            }
        }
    }

    public static List<String> transform(char[][] board) {
        List<String> re = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String temp = String.valueOf(board[i]);
            re.add(temp);
        }
        return re;
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
        TimeCount.begin();
        System.out.println(solveNQueens(5));
        System.out.println("Cost: " + TimeCount.end() + " mills");
    }
}
