package main.java.LeetCode.LeetCode2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rinchar on 2017/11/11.
 */
public class _76_MinimumWindowSubstring {
    //76. Minimum Window Substring (Hard) 13.51%
    public static String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0) return "";
        Map<Character, Integer> tMap = new HashMap<>(), windowMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (tMap.containsKey(c)) tMap.put(c, tMap.get(c) + 1);
            else tMap.put(c, 1);
        }
        int minLen = Integer.MAX_VALUE, letterCount = 0;
        String result = "";
        for (int slow = 0, fast = 0; fast < s.length(); fast++) {
            char charTemp = s.charAt(fast);
            if (tMap.containsKey(charTemp)) {
                if (!windowMap.containsKey(charTemp)) {
                    windowMap.put(charTemp, 1);
                    letterCount++;
                } else if (windowMap.get(charTemp) < tMap.get(charTemp)) {
                    windowMap.put(charTemp, windowMap.get(charTemp) + 1);
                    letterCount++;
                } else {
                    windowMap.put(charTemp, windowMap.get(charTemp) + 1);
                }
            }
            if (letterCount == t.length()) {
                while (true) {
                    char charSlow = s.charAt(slow);
                    if (!tMap.containsKey(charSlow)) slow++;
                    else if (windowMap.get(charSlow) > tMap.get(charSlow)) {
                        windowMap.put(charSlow, windowMap.get(charSlow) - 1);
                        slow++;
                    } else {
                        if (minLen > fast - slow + 1) {
                            minLen = fast - slow + 1;
                            result = s.substring(slow, fast + 1);
                        }
                        letterCount--;
                        windowMap.put(charSlow, windowMap.get(charSlow) - 1);
                        slow++;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
