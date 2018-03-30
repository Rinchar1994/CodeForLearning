package main.java.LeetCode;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Rinchar on 2017/10/17.
 */
public class _22_GenerateParentheses {
    //22. Generate Parentheses (Medium) 42.19%
    public static List<String> generateParenthesis(int n) {
        List<String> re = new ArrayList<>();
        backtrack(re, "", 0, 0, n);
        return re;
    }

    public static void backtrack(List<String> re, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            re.add(str);
            return;
        }
        if(open < max) backtrack(re, str + "(", open + 1, close, max);
        if(close < open) backtrack(re, str + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }
}
