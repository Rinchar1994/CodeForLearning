package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/10/20.
 */
public class _28_ImplementStrStr {
    //28. Implement strStr() (Easy) 71.65%
    public static int strStr(String haystack, String needle) {
        int len_hay = haystack.length(), len_nee = needle.length();
        if (len_nee == 0) return 0;
        else if (len_hay == 0) return -1;
        for (int i = 0; i <= len_hay - len_nee; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + len_nee).compareTo(needle) == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String hay = "a";
        String nee = "a";
        System.out.println(strStr(hay, nee));
    }
}
