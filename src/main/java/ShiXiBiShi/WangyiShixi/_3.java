package main.java.ShiXiBiShi.WangyiShixi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Rinchar on 2018/3/28.
 */
public class _3 {
    /*将m个人物的能力放进map中，使得时间复杂度从N^2降低到N*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t1 = 0, t2 = 0;
        HashMap<Integer, Integer> hs = new HashMap<>(m + n);
        int[] a = new int[n + m];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            t1 = sc.nextInt();
            t2 = sc.nextInt();
            a[i] = t1;
            hs.put(t1, t2);
        }
        for (int i = 0; i < m; i++) {
            t1 = sc.nextInt();
            a[n + i] = t1;
            b[i] = t1;
            if (!hs.containsKey(t1))
                hs.put(t1, 0);
        }
        Arrays.sort(a);
        int max = 0;
        for (int i = 0; i < m + n; i++) {
            max = Math.max(max, hs.get(a[i]));
            hs.put(a[i], max);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(hs.get(b[i]));
        }
    }
}
