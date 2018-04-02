package main.java.LeetCode.LeetCode2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2017/10/26.
 */
public class _54_SpiralMatrix {
    //54. Spiral Matrix (Medium) 11.65%
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> re = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return re;
        cycle(matrix, re, 0);
        return re;
    }

    public static void cycle(int[][] matrix, List<Integer> re, int col) {
        int len = re.size(), m = matrix.length, n = matrix[0].length;
        int mul = m * n;
        for (int j = col; j < n - col; j++) {
            re.add(matrix[col][j]);
            if (++len == mul) return;
        }
        for (int i = col + 1; i < m - col; i++) {
            re.add(matrix[i][n - col - 1]);
            if (++len == mul) return;
        }
        for (int j = n - col - 2; j >= col; j--) {
            re.add(matrix[m - col - 1][j]);
            if (++len == mul) return;
        }
        for (int i = m - col - 2; i > col; i--) {
            re.add(matrix[i][col]);
            if (++len == mul) return;
        }
        cycle(matrix, re, col + 1);
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(a));
    }
}
