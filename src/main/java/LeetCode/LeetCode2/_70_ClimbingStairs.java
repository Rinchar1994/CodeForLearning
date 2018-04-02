package main.java.LeetCode.LeetCode2;

/**
 * Created by Rinchar on 2017/11/7.
 */
public class _70_ClimbingStairs {
    //70. Climbing Stairs (Easy) 0.84%
    //dp
    /*public static int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }*/

    //math 0.84%
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int k = 1, t = 0;
        for (int i = 3; i <= n; i++) {
            int temp = k;
            k = k + t;
            t = temp;
        }
        return (k << 1) + t;
    }


    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println(climbStairs(1000));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + " mills");
    }
}
