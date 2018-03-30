package main.java.WangyiShixi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Rinchar on 2018/3/28.
 */
public class _3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] Di = new int[n], Ai = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Di[i] = in.nextInt();
            int temp = in.nextInt();
            if (map.containsKey(Di[i]) && map.get(Di[i]) >= temp)
                continue;
            map.put(Di[i], temp);
        }
        for (int i = 0; i < m; i++) {
            Ai[i] = in.nextInt();
        }
        Arrays.sort(Di);
        for (int i = 0; i < n - 1; i++) {
            if (map.get(Di[i]) >= map.get(Di[i + 1])) map.remove(Di[i + 1]);
        }
        for (int i = 0; i < m; i++) {
            int re = 0;
            for (int key : map.keySet()) {
                if (Ai[i] >= key) re = Math.max(re, map.get(key));
            }
            System.out.println(re);
        }
    }
}
