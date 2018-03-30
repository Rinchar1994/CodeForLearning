package main.java.LeetCode2;

/**
 * Created by Rinchar on 2017/11/7.
 */
public class _64_MinimumPathSum {
    //64. Minimum Path Sum (Medium) 8.85%
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n;
        try {
            n = grid[0].length;
            if (n == 0) return 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if (j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                else dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
