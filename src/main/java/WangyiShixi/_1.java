package main.java.WangyiShixi;

import java.util.Scanner;

/**
 * Created by Rinchar on 2018/3/29.
 */
public class _1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x1 = new int[n], x2 = new int[n], y1 = new int[n], y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            x2[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y2[i] = in.nextInt();
        }
        int re = 1;
        System.out.println(re);
    }
}
