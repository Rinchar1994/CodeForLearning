package main.java.BiShi.TencentShiXi;

import java.util.Scanner;

/**
 * Created by Rinchar on 2018/4/6.
 */
public class _2 {
    public static void main(String[] args) {
        //每首歌 判断选不选
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int A_len = in.nextInt(), A_num = in.nextInt();
        int B_len = in.nextInt(), B_num = in.nextInt();
        int[][] dp = new int[A_num + B_num + 1][K + 1];
        for (int i = 1; i < A_num + B_num + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                if (i <= A_num) {
                    if (j == A_len) dp[i][j] = (dp[i - 1][j] + 1) % 1000000007;
                    else if (j > A_len) {
                        dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - A_len]) % 1000000007;
                    } else dp[i][j] = dp[i - 1][j];
                } else if (i <= A_num + B_num) {
                    if (j == B_len) dp[i][j] = (dp[i - 1][j] + 1) % 1000000007;
                    else if (j > B_len) {
                        dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - B_len]) % 1000000007;
                    } else dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[A_num + B_num][K]);
    }
}
