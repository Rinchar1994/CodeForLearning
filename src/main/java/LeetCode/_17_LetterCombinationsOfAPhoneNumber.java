package main.java.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2017/10/17.
 */
public class _17_LetterCombinationsOfAPhoneNumber {
    //17. Letter Combinations of a Phone Number (Medium) 76.82%
    private static String[][] button = {{"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}};

    public static List<String> letterCombinations(String digits) {
        List<String> re = new ArrayList<>();
        if (digits.length() == 0) {
            return re;
        }
        if (digits.charAt(0) > '9' || digits.charAt(0) < '2') {
            return re;
        }
        for(int i = 0; i < button[digits.charAt(0)-'2'].length; i++) {
            re.add(button[digits.charAt(0) - '2'][i]);
        }
        re = letterCombinSub(re, digits.substring(1));
        return re;
    }

    public static List<String> letterCombinSub(List<String> re, String digits) {
        if (digits.length() == 0) {
            return re;
        }
        if (digits.charAt(0) > '9' || digits.charAt(0) < '2') {
            return new ArrayList<String>();
        }
        int lenList = re.size();
        for(int i = 0; i < lenList; i++) {
            String temp = re.get(0);
            for(int j = 0; j < button[digits.charAt(0)-'2'].length; j++) {
                re.add(temp + button[digits.charAt(0) - '2'][j]);
            }
            re.remove(0);
        }
        re = letterCombinSub(re, digits.substring(1));
        return re;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
