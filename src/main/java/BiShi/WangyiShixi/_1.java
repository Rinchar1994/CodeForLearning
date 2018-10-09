package main.java.BiShi.WangyiShixi;

import java.util.Scanner;

/**
 * Created by Rinchar on 2018/3/29.
 */
public class _1 {
    /*
     * 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
     * 如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
     * 请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
     */
    /*
     * 输入包括五行。
     * 第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
     * 第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
     * 第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
     * 第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
     * 第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
     * */
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
