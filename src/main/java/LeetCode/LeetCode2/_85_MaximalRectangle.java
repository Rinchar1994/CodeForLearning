package main.java.LeetCode.LeetCode2;

/**
 * Created by Rinchar on 2017/11/17.
 */
public class _85_MaximalRectangle {
    //85. Maximal Rectangle (Hard) 1.71%
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dpArea = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) dpArea[i][j] = matrix[i][j] - '0';
                else if (i == 0) dpArea[i][j] = matrix[i][j] - '0' + dpArea[i][j - 1];
                else if (j == 0) dpArea[i][j] = matrix[i][j] - '0' + dpArea[i - 1][j];
                else dpArea[i][j] = dpArea[i - 1][j] + dpArea[i][j - 1] - dpArea[i - 1][j - 1] + matrix[i][j] - '0';
            }
        }
        int max = 0;
        for (int iStart = 0; iStart < matrix.length; iStart++) {
            for (int jStart = 0; jStart < matrix[0].length; jStart++) {
                for (int iEnd = iStart; iEnd < matrix.length; iEnd++) {
                    for (int jEnd = jStart; jEnd < matrix[0].length; jEnd++) {
                        if (jEnd == jStart && iStart == iEnd) max = Math.max(max, (matrix[iStart][jStart] - '0'));
                        else {
                            if (iStart == 0 && jStart == 0) {
                                if ((iEnd + 1) * (jEnd + 1) == dpArea[iEnd][jEnd])
                                    max = Math.max(max, dpArea[iEnd][jEnd]);
                                else break;
                            } else {
                                if (iStart == 0) {
                                    int temp = dpArea[iEnd][jEnd] - dpArea[iEnd][jStart - 1];
                                    if (temp == (iEnd - iStart + 1) * (jEnd - jStart + 1))
                                        max = Math.max(max, temp);
                                    else break;
                                } else if (jStart == 0) {
                                    int temp = dpArea[iEnd][jEnd] - dpArea[iStart - 1][jEnd];
                                    if (temp == (iEnd - iStart + 1) * (jEnd - jStart + 1))
                                        max = Math.max(max, temp);
                                    else break;
                                } else {
                                    int temp = dpArea[iEnd][jEnd] - (dpArea[iStart - 1][jEnd]
                                            + dpArea[iEnd][jStart - 1] - dpArea[iStart - 1][jStart - 1]);
                                    if (temp == (iEnd - iStart + 1) * (jEnd - jStart + 1))
                                        max = Math.max(max, temp);
                                    else break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] a = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(a));
    }
}
