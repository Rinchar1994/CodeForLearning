package main.java.BiShi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Rinchar
 * @date: 2018/9/28
 **/
public class IqiyiBishi_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int temp = in.nextInt();
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        int num = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > num) {
                num = map.get(key);
            }
        }
        System.out.println(num);
    }
}
