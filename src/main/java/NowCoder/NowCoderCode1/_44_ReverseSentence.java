package main.java.NowCoder.NowCoderCode1;

/**
 * Created by Rinchar on 2018/4/30.
 */
public class _44_ReverseSentence {
    public static String ReverseSentence(String str) {
        if (str.trim().equals("")) return str;
        String[] strArr = str.split(" ");
        StringBuilder reStr = new StringBuilder(strArr[strArr.length - 1]);
        for (int i = strArr.length - 2; i >= 0; i--) {
            reStr.append(" " + strArr[i]);
        }
        return reStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence(""));
    }
}
