package main.java.NowCoder.NowCoderCode1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rinchar on 2018/4/25.
 */
public class _34_FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) return -1;
        Map<Character, Integer> chMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (chMap.containsKey(ch)) chMap.put(ch, chMap.get(ch) + 1);
            else chMap.put(ch, 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (chMap.get(str.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
