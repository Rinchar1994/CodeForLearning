package main.java.NowCoder;

/**
 * Created by Rinchar on 2018/3/7.
 */
public class _2_ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        int index = -1;
        while ((index = str.indexOf(" ")) != -1) {
            str.replace(index, index + 1, "%20");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("We Are Happy.");
        System.out.println(replaceSpace(a));
    }
}
