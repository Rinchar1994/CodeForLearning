package main.java.LeetCode.LeetCode2;

/**
 * Created by Rinchar on 2017/11/10.
 */
public class _74_SearchA2DMatrix {
    //74. Search a 2D Matrix (Medium) 40.73%
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;
        int head = 0, tail = matrix.length * matrix[0].length - 1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            int valueMid = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if (valueMid < target) head = mid + 1;
            else if (valueMid > target) tail = mid - 1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 35, 50}};
        System.out.println(searchMatrix(a, 51));
    }
}
