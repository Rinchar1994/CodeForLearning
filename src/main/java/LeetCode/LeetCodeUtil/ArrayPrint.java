package main.java.LeetCode.LeetCodeUtil;

/**
 * Created by Rinchar on 2017/10/22.
 */
public class ArrayPrint {
    public static String intArrPrint(int[] arr) {
        String re = "[";
        for (int a : arr) {
            re += Integer.toString(a) + ", ";
        }
        re = re.substring(0, re.length() - 2) + "]";
        return re;
    }

    public static String strArrPrint(String[] arr) {
        String re = "[";
        for (String a : arr) {
            re += "\"" + a + "\", ";
        }
        re = re.substring(0, re.length() - 2) + "]";
        return re;
    }
}
