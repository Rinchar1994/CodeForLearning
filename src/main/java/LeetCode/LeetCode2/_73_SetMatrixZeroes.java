package main.java.LeetCode.LeetCode2;

import main.java.LeetCode.LeetCodeUtil.ArrayPrint;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rinchar on 2017/11/10.
 */
public class _73_SetMatrixZeroes {
    //73. Set Matrix Zeroes (Medium) 8.61%
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n;
        try {
            n = matrix[0].length;
            if (n == 0) return;
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
        Map<Integer, Integer> rowMap = new HashMap<>(), colMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowMap.put(i, 1);
                    colMap.put(j, 1);
                }
            }
        }
        for (int i : rowMap.keySet()) {
            for (int j = 0; j < n; j++) matrix[i][j] = 0;
        }
        for (int j : colMap.keySet()) {
            for (int i = 0; i < m; i++) matrix[i][j] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] ma = {{0, 0, 0, 5}, {4, 3, 1, 4}, {0, 1, 1, 4}, {1, 2, 1, 3}, {0, 0, 1, 1}};
        setZeroes(ma);
        for (int i = 0; i < ma.length; i++) {
            System.out.println(ArrayPrint.intArrPrint(ma[i]));
        }
    }
}
