package main.java.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rinchar on 2017/9/29.
 */


public class _6_Conversion {
    //6.ZigZag Conversion (Medium)
    //input "abcdefghijk" 4
    /*
    * a     g
    * b   f h
    * c e   i k
    * d     j  */
    public static String convert(String s, int numRows) {
        if (numRows >= s.length() || numRows == 1) {
            return s;
        }
        StringBuilder re = new StringBuilder();
        int per_cycle_len = numRows * 2 - 2;
        int cycle_num = s.length() / per_cycle_len;
        int exce_num = s.length() % per_cycle_len;
        for(int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int cnt = 0;
                while (per_cycle_len * cnt + i < s.length()) {
                    re.append(s.charAt(per_cycle_len * cnt + i));
                    cnt++;
                }
            } else {
                int cnt = 0;
                while (per_cycle_len * cnt + i < s.length()) {
                    re.append(s.charAt(per_cycle_len * cnt + i));
                    if (per_cycle_len * cnt + per_cycle_len - i < s.length()) {
                        re.append(s.charAt(per_cycle_len * cnt + per_cycle_len - i));
                    }
                    cnt++;
                }
            }
        }
        return re.toString();
    }

    public static void main(String[] args) {
        String a = "";
        int b = 4;
        System.out.println(convert(a, b));;
    }
}
