package main.java.NowCoder.NowCoderCode;

import main.java.NowCoder.NowCoderUtil.ArrayPrint;

import java.util.ArrayList;

/**
 * Created by Rinchar on 2018/3/14.
 */
public class _19_PrintMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> re = new ArrayList<>();
        if (matrix.length != 0 && matrix[0].length != 0) {
            re.addAll(printOuterMatrix(matrix, 0, 0, matrix.length, matrix[0].length));
        }
        return re;
    }

    public static ArrayList<Integer> printOuterMatrix(int[][] matrix, int beginX, int beginY,
                                                      int endX, int endY) {
        ArrayList<Integer> temp = new ArrayList<>();
        if (beginX >= endX || beginY >= endY) return temp;
        for (int j = beginY; j < endY; j++) {
            temp.add(matrix[beginX][j]);
        }
        for (int i = beginX + 1; i < endX; i++) {
            temp.add(matrix[i][endY - 1]);
        }
        if (beginX + 1 != endX) {
            for (int j = endY - 2; j >= beginY; j--) {
                temp.add(matrix[endX - 1][j]);
            }
        }
        if (beginY + 1 != endY) {
            for (int i = endX - 2; i > beginX; i--) {
                temp.add(matrix[i][beginY]);
            }
        }
        temp.addAll(printOuterMatrix(matrix, beginX + 1, beginY + 1,
                endX - 1, endY - 1));
        return temp;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3, 4}};
        System.out.println(ArrayPrint.intArrPrint(printMatrix(m)));
    }
}
