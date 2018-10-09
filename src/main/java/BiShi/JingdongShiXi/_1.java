package main.java.BiShi.JingdongShiXi;

import java.util.Scanner;

/**
 * Created by Rinchar on 2018/4/9.
 */
public class _1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.length() == 0) System.out.println(0);
        else if (str.length() == 1) System.out.println(1);
        else {
            StringBuilder temp = new StringBuilder(str);
            temp = temp.reverse();
//            int re = hhh(str, temp.toString());
            int re = longestPalindromeSubSequence(str);
            re = str.length() + (re + 1) / 2;
            System.out.println(re);
            System.out.println(numOfPalindromeSubSequence(str));
        }
    }

    public static int longestPalindromeSubSequence(String string) {
        int[][] dp = new int[string.length()][string.length()];
        for (int i = string.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][string.length() - 1];
    }

    public static int numOfPalindromeSubSequence(String string) {
        int len = string.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (string.charAt(i) == string.charAt(j))
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + 1 + dp[i + 1][j - 1];
                else dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
            }
        }
        return dp[0][len - 1];
    }

    public static int hhh(String s1, String s2) {
        int size1 = s1.length();
        int size2 = s2.length();
        int chess[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= size1; i++) {//根据上面提到的公式计算矩阵
            for (int j = 1; j <= size2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    chess[i][j] = chess[i - 1][j - 1] + 1;
                } else {
                    chess[i][j] = Math.max(chess[i][j - 1], chess[i - 1][j]);
                }
            }
        }
        int i = size1;
        int j = size2;
        StringBuffer sb = new StringBuffer();
        while ((i != 0) && (j != 0)) {//利用上面得到的矩阵计算子序列，从最右下角往左上走
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));//相同时即为相同的子串
                i--;
                j--;
            } else {
                if (chess[i][j - 1] > chess[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        float sum = ((float) sb.length() / s2.length() + (float) sb.length() / s1.length()) / 2;
        //System.out.println((double)sb.length()/s2.length()+","+(double)sb.length()/s1.length());
        return sb.length();
    }
}
