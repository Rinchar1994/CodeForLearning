package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/10/11.
 */
public class _9_PalindromeNumber {
    //9. Palindrome Number (Easy)
    // 注意输入为10时
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int x_com = 0;
        int len = ((int) Math.log10(x)) + 1;
        for (int i = 0; i < len / 2; i++) {
            x_com = x_com * 10 + x % 10;
            x /= 10;
        }
        if (len % 2 == 1) {
            if (x / 10 == x_com) {
                return true;
            } else {
                return false;
            }
        } else {
            if (x == x_com) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int x = 01;
        System.out.println(isPalindrome(x));
    }
}
