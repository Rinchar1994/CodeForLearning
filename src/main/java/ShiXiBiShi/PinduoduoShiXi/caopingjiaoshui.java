package main.java.ShiXiBiShi.PinduoduoShiXi;

import java.util.Scanner;

/**
 * Created by Rinchar on 2018/4/27.
 */
public class caopingjiaoshui {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] area = new int[n];
        for (int i = 0; i < n; i++) {
            area[i] = in.nextInt();
        }
        in.nextLine();
        for (int i = 0; i < m; i++) {
            String str = in.nextLine();
            String[] strArr = str.split(" ");
            int x = Integer.parseInt(strArr[1]);
            int y = Integer.parseInt(strArr[2]);
            if (strArr[0].equals("Q")) {
                if (y == 0) {
                    System.out.println(area[x - 1]);
                    continue;
                }
                int cnt = 0;
                if (x - y >= 1 && x + y <= area.length) {
                    for (int k = x - y; k <= x + y; k++) cnt += area[k - 1];
                } else if (x - y < 1 && x + y <= area.length) {
                    for (int k = 1; k <= x + y; k++) cnt += area[k - 1];
                } else if (x - y >= 1 && x + y > area.length) {
                    for (int k = x - y; k <= area.length; k++) cnt += area[k - 1];
                } else {
                    for (int k = 1; k <= area.length; k++) cnt += area[k - 1];
                }
                System.out.println(cnt);
            } else if (strArr[0].equals("C")) {
                int temp = area[x - 1];
                area[x - 1] = area[y - 1];
                area[y - 1] = temp;
            } else if (strArr[0].equals("D")) {
                area[x - 1] -= y;
            } else if (strArr[0].equals("A")) {
                area[x - 1] += y;
            }
        }
    }
}
