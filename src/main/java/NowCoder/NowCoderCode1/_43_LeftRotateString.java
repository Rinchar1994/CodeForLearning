package main.java.NowCoder.NowCoderCode1;

/**
 * Created by Rinchar on 2018/4/30.
 */
public class _43_LeftRotateString {
    public static String LeftRotateString(String str, int n) {
        if(str.length() == 0) return str;
        int len = str.length();
        n = n % len;
        return str.substring(n) + str.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef", 3));
    }
}
