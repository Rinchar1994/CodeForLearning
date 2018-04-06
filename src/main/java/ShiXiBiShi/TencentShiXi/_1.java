package main.java.ShiXiBiShi.TencentShiXi;

import java.util.Scanner;

/**
 * Created by Rinchar on 2018/4/5.
 */
public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();
        long count = m * m;
        long sum = n / (2 * m) * count;
        System.out.println(sum);
    }
}
