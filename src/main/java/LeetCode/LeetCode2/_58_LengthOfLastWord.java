package main.java.LeetCode.LeetCode2;

/**
 * Created by Rinchar on 2017/10/30.
 */
public class _58_LengthOfLastWord {
    //58. Length of Last Word (Easy) 22.07%
    public static int lengthOfLastWord(String s) {
        String[] a = s.split(" ");
        if (a.length == 0) return 0;
        return a[a.length - 1].length();
    }
}
