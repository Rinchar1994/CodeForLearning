package main.java.LeetCode.LeetCode1;

import java.util.Stack;

/**
 * Created by Rinchar on 2017/10/22.
 */
public class _32_LongestValidParentheses {
    //32. Longest Valid Parentheses (Hard) 15.14%
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s = ")()(((())))(";
        System.out.println(longestValidParentheses(s));
    }
}
