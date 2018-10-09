package main.java.BiShi.ZijietiaodongBiShi;

import java.util.Scanner;

/**
 * Created by Rinchar on 2018/4/15.
 */
public class _2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt(), n2 = in.nextInt(), m = in.nextInt();
        int[] a = new int[n1], b = new int[n2];
        for (int i = 0; i < n1; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            b[i] = in.nextInt();
        }
        int[][] dp = new int[n1 + n2 + 1][m + 1];
        for (int i = 1; i <= n1; i++) {
            for (int v = 1; v <= m; v++) {
                if (a[i-1] == v) {
                    dp[i][v] = (1 + dp[i - 1][v]) % 1000000007;
                } else {
                    dp[i][v] = (dp[i - 1][v] + (v >= a[i - 1] ? dp[i][v - a[i - 1]] : 0))
                            % 1000000007;
                }
            }
        }
        for (int i = n1 + 1; i <= n1 + n2; i++) {
            for (int v = 1; v <= m; v++) {
                dp[i][v] = (dp[i - 1][v] + (v >= b[i - n1 - 1] ? dp[i - 1][v - b[i - n1 - 1]] : 0))
                        % 1000000007;
            }
        }
        System.out.println(dp[n1 + n2][m]);
    }
}
