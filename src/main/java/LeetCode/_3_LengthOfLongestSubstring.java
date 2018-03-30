package main.java.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rinchar on 2017/9/29.
 */
public class _3_LengthOfLongestSubstring {
    //3. Longest SubString Without Repeating Characters (Medium)
    //虽然跑出来是对的，但是时间复杂度太高
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        int lenMax = 0;
        for (int i = 0; i < charArray.length; ) {
            if (charMap.containsKey(charArray[i])) {
                i = charMap.get(charArray[i]) + 1;
                lenMax = lenMax >= charMap.size() ? lenMax : charMap.size();
                charMap.clear();
            } else {
                charMap.put(charArray[i], i);
                i++;
            }
        }
        return lenMax >= charMap.size() ? lenMax : charMap.size();
    }

    public int lengthOfLongestSubstringVer2(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int lenMax = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                j = Math.max(j, charMap.get(s.charAt(i)) + 1);
            }
            charMap.put(s.charAt(i), i);
            lenMax = Math.max(lenMax, i - j + 1);
        }
        return lenMax;
    }
}
