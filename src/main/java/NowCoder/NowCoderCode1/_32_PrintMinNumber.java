package main.java.NowCoder.NowCoderCode1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Rinchar on 2018/4/17.
 */
public class _32_PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        if (numbers.length == 0) return "";
        ArrayList<String> strs = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            strs.add(Integer.toString(numbers[i]));
        }
        Collections.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                String temp1 = a + b, temp2 = b + a;
                return temp1.compareTo(temp2);
            }
        });
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) str.append(strs.get(i));
        return str.toString();
    }
}
