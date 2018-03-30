package main.java.NowCoderUtil;

import java.util.ArrayList;

/**
 * Created by Rinchar on 2018/3/14.
 */
public class ArrayPrint {
    public static String intArrPrint(ArrayList<Integer> arr) {
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
