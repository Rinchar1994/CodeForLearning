package main.java.LeetCode.LeetCode2;

/**
 * Created by Rinchar on 2017/11/15.
 */
public class _79_WordSearch {
    //79. Word Search (Medium) 37.70%
    public static boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        int[][] boardState = new int[board.length][board[0].length];
        return existSub(board, boardState, word, 0, 0, 0);
    }

    public static boolean existSub(char[][] board, int[][] boardState, String word, int x, int y, int pos) {
        if (pos == word.length()) return true;
        if (pos == 0) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        boardState[i][j] = 1;
                        if (existSub(board, boardState, word, i, j, pos + 1)) return true;
                        boardState[i][j] = 0;
                    }
                }
            }
        } else {
            if (x > 0 && board[x - 1][y] == word.charAt(pos) && boardState[x - 1][y] != 1) {
                boardState[x - 1][y] = 1;
                if (existSub(board, boardState, word, x - 1, y, pos + 1)) return true;
                boardState[x - 1][y] = 0;
            }
            if (y > 0 && board[x][y - 1] == word.charAt(pos) && boardState[x][y - 1] != 1) {
                boardState[x][y - 1] = 1;
                if (existSub(board, boardState, word, x, y - 1, pos + 1)) return true;
                boardState[x][y - 1] = 0;
            }
            if (y < board[0].length - 1 && board[x][y + 1] == word.charAt(pos) && boardState[x][y + 1] != 1) {
                boardState[x][y + 1] = 1;
                if (existSub(board, boardState, word, x, y + 1, pos + 1)) return true;
                boardState[x][y + 1] = 0;
            }
            if (x < board.length - 1 && board[x + 1][y] == word.charAt(pos) && boardState[x + 1][y] != 1) {
                boardState[x + 1][y] = 1;
                if (existSub(board, boardState, word, x + 1, y, pos + 1)) return true;
                boardState[x + 1][y] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] a = {{'a', 'a'}};
        String b = "aaa";
        System.out.println(exist(a, b));
    }
}
