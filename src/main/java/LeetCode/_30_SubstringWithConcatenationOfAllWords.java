package main.java.LeetCode;

import java.util.*;

/**
 * Created by Rinchar on 2017/10/20.
 */
public class _30_SubstringWithConcatenationOfAllWords {
    //30. Substring with Concatenation of All Words (Hard) 84.84%
    //一开始没有用map，然后time limit
    public static List<Integer> findSubString(String s, String[] words) {
        List<Integer> re = new ArrayList<>();
        int len_word0 = words[0].length();
        int len = words.length * len_word0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) map.put(words[i], map.get(words[i]) + 1);
            else map.put(words[i], 1);
        }
        //这里遍历的长度很关键
        for (int i = 0; i < len_word0; i++) {
            int cnt = 0;
            int left = i;
            Map<String, Integer> curMap = new HashMap<>();
            for (int j = i; j <= s.length() - len_word0; j += len_word0) {
                String temp = s.substring(j, j + len_word0);
                if (map.containsKey(temp)) {
                    if (curMap.containsKey(temp)) curMap.put(temp, curMap.get(temp) + 1);
                    else curMap.put(temp, 1);
                    if (curMap.get(temp) <= map.get(temp)) cnt++;
                    else {
                        while (curMap.get(temp) > map.get(temp)) {
                            String tempLeft = s.substring(left, left + len_word0);
                            curMap.put(tempLeft, curMap.get(tempLeft) - 1);
                            if (curMap.get(tempLeft) < map.get(tempLeft)) cnt--;
                            left += len_word0;
                        }
                    }
                    if (cnt == words.length) re.add(left);
                } else {
                    curMap.clear();
                    cnt = 0;
                    left = j + len_word0;
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        String a = "aaa";
        String[] b = {"a","a"};
        System.out.println(findSubString(a, b));
    }
}
