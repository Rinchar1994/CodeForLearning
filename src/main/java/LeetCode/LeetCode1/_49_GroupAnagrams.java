package main.java.LeetCode.LeetCode1;

import java.util.*;

/**
 * Created by Rinchar on 2017/10/24.
 */
public class _49_GroupAnagrams {
    //49. Group Anagrams (Medium) 52.18%
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        List<List<String>> re = new ArrayList<>();
        for (String key : map.keySet()) {
            re.add(map.get(key));
        }
        return re;
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(str));
    }
}
