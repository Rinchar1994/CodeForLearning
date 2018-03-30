package main.java.LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Rinchar on 2017/10/17.
 */
public class _20_ValidParentheses {
    //20. Valid Parentheses (Easy) 52.16%
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> characterStack = new Stack<>();
        List<Character> left = Arrays.asList('(', '{', '[');
        List<Character> right = Arrays.asList(')', '}', ']');
        for (Character key : s.toCharArray()) {
            if (left.contains(key)) {
                characterStack.push(key);
            } else if (right.contains(key)) {
                if (characterStack.size() > 0 && characterStack.peek() == left.get(right.indexOf(key))) {
                    characterStack.pop();
                } else return false;
            } else return false;
        }
        if(characterStack.size() == 0) return true;
        else return false;
    }
}
