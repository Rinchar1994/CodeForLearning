package main.java.BiShi;

import java.util.Scanner;

/**
 * @author: Rinchar
 * @date: 2018/9/28
 **/
public class IqiyiBishi_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[][] dp = new long[n + 1][(n + 1) / 2 + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= (i + 1) / 2; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if(i == 1) {
                    dp[i][j] = dp[i - 1][j] + 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i - 2][j - 1];
            }
        }
        long re = 0;
        for (int i = 0; i <= (n + 1) / 2; i++) {
            re += dp[n][i];
        }
        System.out.println(re);
    }
}
