package main.java.LeetCode.LeetCode2;

/**
 * Created by Rinchar on 2017/11/16.
 */
public class _91_DecodeWays {
    //91. Decode Ways (Medium) 90.34%
    public static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) dp[i] = 1;
            else {
                if (s.charAt(i) == '0' && (s.charAt(i - 1) <= '0' || s.charAt(i - 1) > '2')) return 0;
                if (s.charAt(i - 1) == '1') {
                    if (s.charAt(i) > '0') {
                        if (i > 1) dp[i] = dp[i - 1] + dp[i - 2];
                        else dp[i] = 2;
                    } else dp[i] = i > 1 ? dp[i - 2] : 1;
                } else if (s.charAt(i - 1) == '2') {
                    if (s.charAt(i) > '0' && s.charAt(i) < '7') {
                        if (i > 1) dp[i] = dp[i - 1] + dp[i - 2];
                        else dp[i] = 2;
                    } else if (s.charAt(i) == '0') dp[i] = i > 1 ? dp[i - 2] : 1;
                    else dp[i] = dp[i - 1];
                } else dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "100";
        System.out.println(numDecodings(s));
    }
}
