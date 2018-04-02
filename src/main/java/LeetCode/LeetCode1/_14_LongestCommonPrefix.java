package main.java.LeetCode.LeetCode1;

/**
 * Created by Rinchar on 2017/10/16.
 */
public class _14_LongestCommonPrefix {
    //14. Longest Common Prefix (Easy) 37.69%
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        int minLen = Integer.MAX_VALUE;
        for (String key : strs) {
            minLen = Math.min(key.length(), minLen);
        }
        int head = 0, tail = minLen;
        String re = "";
        while (head <= tail) {
            int mid = (head + tail) / 2;
            String common = strs[0].substring(0, mid);
            int i = 1;
            for(; i < strs.length; i++) {
                if (strs[i].substring(0, mid).compareTo(common) != 0) {
                    tail = mid - 1;
                    break;
                }
            }
            if (i == strs.length) {
                re = common;
                head = mid + 1;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        String a = "123";
        System.out.println(a.contains("1234"));
    }
}
