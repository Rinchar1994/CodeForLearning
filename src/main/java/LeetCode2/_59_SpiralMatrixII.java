package main.java.LeetCode2;

import main.java.LeetCodeUtil.ArrayPrint;

/**
 * Created by Rinchar on 2017/10/30.
 */
public class _59_SpiralMatrixII {
    //59. Spiral Matrix II (Medium) 8.10%
    public static int[][] generateMatrix(int n) {
        int[][] re = new int[n][n];
        if (n == 0) return re;
        cycleIn(re, 0, 1);
        return re;
    }

    public static void cycleIn(int[][] re, int col, int num) {
        int n = re.length;
        for (int j = col; j < n - col; j++) {
            re[col][j] = num++;
            if (num > n * n) return;
        }
        for (int i = col + 1; i < n - col; i++) {
            re[i][n - col - 1] = num++;
            if (num > n * n) return;
        }
        for (int j = n - col - 2; j >= col; j--) {
            re[n - col - 1][j] = num++;
            if (num > n * n) return;
        }
        for (int i = n - col - 2; i > col; i--) {
            re[i][col] = num++;
            if (num > n * n) return;
        }
        cycleIn(re, col + 1, num);
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] a = generateMatrix(n);
        for(int i = 0; i < n; i++) {
            System.out.println(ArrayPrint.intArrPrint(a[i]));
        }
    }
}
