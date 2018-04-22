package main.java.ShiXiBiShi.AiqiyiShiXi;

import java.util.Scanner;

/**
 * Created by Rinchar on 2018/4/19.
 */
public class _3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] v = new int[n];
        int aaa;
        for (int i = 0; i < n; i++) {
            aaa = in.nextInt();
            m -= aaa;
            v[i] = in.nextInt();
        }
        System.out.println(m);
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j == 1) {
                    if (i == 1) dp[i][j] = (v[0] == 0 ? 0 : 1);
                    else dp[i][j] = dp[i - 1][j] + (v[i - 1] == 0 ? 0 : 1);
                } else {
                    if (i == 1) {
                        if(v[i-1] >= j) dp[i][j] = 1;
                    } else {
                        if(v[i-1] >= j) dp[i][j] = 1;
                        int temp = (j - v[i - 1]) > 0 ? j - v[i - 1] : 1;
                        for (int k = j; k >= temp; k--) {
                            dp[i][j] += dp[i - 1][k];
                        }
                    }
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
