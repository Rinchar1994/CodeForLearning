package main.java.LeetCode.LeetCode2;

/**
 * Created by Rinchar on 2017/11/6.
 */
public class _63_UniquePathsII {
    //63. Unique Paths II (Medium) 3.26%
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n;
        try {
            n = obstacleGrid[0].length;
            if (n == 0) return 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] != 1) dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i][j - 1] : 0;
                else if (j == 0) dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] : 0;
                else {
                    if (obstacleGrid[i][j] != 1) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(a));
    }
}
