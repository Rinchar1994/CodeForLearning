package main.java.LeetCode;

import main.java.LeetCodeUtil.ArrayPrint;

/**
 * Created by Rinchar on 2017/10/24.
 */
public class _48_RotateImage {
    //48. Rotate Image (Medium) 2.92%
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        float origin = (float) (len - 1) / 2;
        for (int i = 0; i < origin; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                int temp1 = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                int temp2 = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = temp1;
                temp1 = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = temp2;
                matrix[len - 1 - j][i] = temp1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] ma = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotate(ma);
        for (int i = 0; i < ma.length; i++) {
            System.out.println(ArrayPrint.intArrPrint(ma[i]));
        }
    }
}
