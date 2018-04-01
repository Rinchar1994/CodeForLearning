package main.java.ShiXiBiShi.WangyiShixi;

import java.util.Scanner;

/**
 * Created by Rinchar on 2018/3/29.
 */
public class _1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x1 = new int[n], x2 = new int[n], y1 = new int[n], y2 = new int[n];
        int[] X = new int[n + n], Y = new int[n + n];
        for (int i = 0; i < n; i++) {
            x1[i] = in.nextInt();
            X[i] = x1[i];
        }
        for (int i = 0; i < n; i++) {
            y1[i] = in.nextInt();
            Y[i] = y1[i];
        }
        for (int i = 0; i < n; i++) {
            x2[i] = in.nextInt();
            X[n + i] = x2[i];
        }
        for (int i = 0; i < n; i++) {
            y2[i] = in.nextInt();
            Y[n + i] = y2[i];
        }
        int re = 1;
        for (int x : X) {
            for (int y : Y) {
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (x > x1[i] && y > y1[i] && x <= x2[i] && y <= y2[i]) {
                        cnt++;
                    }
                }
                re = Math.max(cnt, re);
            }
        }
        System.out.println(re);
    }
}
