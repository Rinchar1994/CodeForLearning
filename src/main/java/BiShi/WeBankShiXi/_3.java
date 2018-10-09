package main.java.BiShi.WeBankShiXi;

import java.util.Scanner;

/**
 * Created by Rinchar on 2018/4/16.
 */
public class _3 {
    //边界情况没考虑完整，可以考虑用数组来存储，方案应该可行
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        if (N == 0) System.out.println(1);
        long n = N;
        int num = 0;
        while (n > 0) {
            num++;
            n /= 2;
        }
        int re = 0;
        for (int i = 1; i < num; i++) {
            if (i == 1) {
                re += 2;
            } else {
                re += Math.pow(2, (i - 1) / 2);
            }
        }
        System.out.println(re);
        n = N;
        long temp = 0;
        for (int i = 0; i < num - 1; i++) {
            if (i < num / 2) {
                temp = n % 2;
                n /= 2;
                continue;
            } else if (i == num / 2) {
                if (num % 2 == 1) {
                    temp = n % 2;
                    if (n % 2 == 1) {
                        if (N % 2 == 1) re += 2;
                        else re += 1;
                    } else re += 1;
                } else {
                    if (n % 2 == 1 && temp == 1) re += 2;
                    else re++;
                }
                n /= 2;
            } else {
                if (n % 2 == 0) {
                    continue;
                } else {
                    long len = 2 * i + 2 - num;
                    re += Math.pow(2, (len -1 ) / 2);
                }
                n /= 2;
            }
        }
        System.out.println(re);
    }
}
