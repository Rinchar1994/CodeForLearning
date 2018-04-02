package main.java.LeetCode.LeetCode1;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rinchar on 2017/10/15.
 */
public class _13_RomanToInteger {
    //13. Roman to Integer (Easy) 5.62%
    public static int romanToInt(String s) {
        Map<Character, Integer> RomanMap = new HashMap<>();
        RomanMap.put('I', 1);
        RomanMap.put('V', 5);
        RomanMap.put('X', 10);
        RomanMap.put('L', 50);
        RomanMap.put('C', 100);
        RomanMap.put('D', 500);
        RomanMap.put('M', 1000);
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            if (i == 0) {
                result += RomanMap.get(s.charAt(i));
            } else if (RomanMap.get(s.charAt(i)) > RomanMap.get(s.charAt(i - 1))) {
                result = result - RomanMap.get(s.charAt(i - 1)) * 2 + RomanMap.get(s.charAt(i));
            } else {
                result += RomanMap.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "MMMDLXXXVI";
        System.out.println(romanToInt(s));
    }
}
