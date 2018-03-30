package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/9/29.
 */
public class _5_LongestPalindrome {
    //5.Longest Palindromic Substring (Medium)
    //Expand Around Center
    public String longestPalindrome(String s) {
        int len = s.length(), head = 0, tail = 0;
        for (int i = 0; i < len; i++) {
            int len_odd = getLongestPalindrome(s, i, i);
            int len_even = getLongestPalindrome(s, i, i + 1);
            int lenPal = Math.max(len_even, len_odd);
            if (lenPal > tail - head + 1) {
                head = i - (lenPal - 1) / 2;
                tail = i + lenPal / 2;
            }
        }
        return s.substring(head, tail + 1);
    }

    private int getLongestPalindrome(String s, int pos_l, int pos_r) {
        while (pos_l >= 0 && pos_r < s.length() && s.charAt(pos_l) == s.charAt(pos_r)) {
            pos_l--;
            pos_r++;
        }
        return pos_r - pos_l - 1;
    }
}
