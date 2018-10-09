package main.java.BiShi.ZijietiaodongBiShi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rinchar on 2018/4/22.
 */
public class Mianshi {
    public static String subStr(String a) {
        if (a.length() == 0) return "";
        int head = 0, tail = 0, head_temp = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (map.containsKey(ch)) {
                int temp = i - head_temp;
                int pos = map.get(ch);
                for (int j = head; j < map.get(ch); j++) map.remove(a.charAt(j));
                if (temp > max) {
                    head = head_temp;
                    tail = i;
                    max = temp;
                }
                head_temp = map.get(ch) + 1;
            }
            map.put(ch, i);
        }
        if (max < a.length() - 1 - head_temp) return a.substring(head_temp, a.length());
        else return a.substring(head, tail);
    }

    public static void main(String[] args) {
        String a = "abacefcghij";
        System.out.println(subStr(a));
    }
}
