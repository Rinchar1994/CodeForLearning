package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/10/24.
 */
public class _44_WildcardMatching {
    //44. Wildcard Matching (Hard) 10.36%
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                if (dp[0][j]) dp[0][j + 1] = true;
                int i = -1;
                while (i < s.length() && !dp[i + 1][j]) i++;
                for (; i < s.length(); i++) dp[i + 1][j + 1] = true;
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String a = "aab";
        String b = "c*a*b";
        System.out.println(isMatch(a, b));
    }
}
