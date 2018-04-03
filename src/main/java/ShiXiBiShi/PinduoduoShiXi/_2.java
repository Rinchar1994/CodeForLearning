package main.java.ShiXiBiShi.PinduoduoShiXi;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Rinchar on 2018/4/3.
 */
public class _2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] a = str.split(":");
        int h = Integer.valueOf(a[0]), m = Integer.valueOf(a[1]);
        int re_h = (h % 12) * 30;
        int re_m = m * 6;
        if (m % 2 == 1) {
            BigDecimal re_h_ = new BigDecimal(re_h);
            BigDecimal re_m_ = new BigDecimal(re_m);
            BigDecimal re_h_m = new BigDecimal(m);
            re_h_m = re_h_m.divide(new BigDecimal(2));
            re_h_ = re_h_.add(re_h_m);
            BigDecimal re = re_h_.subtract(re_m_);
            re = re.abs();
            double re_b = re.setScale(1, BigDecimal.ROUND_HALF_DOWN).doubleValue();
            if (re_b > 180.0) {
                System.out.println(360.0 - re_b);
            } else {
                System.out.println(re_b);
            }
        } else {
            re_h += m / 2;
            int re = Math.abs(re_h - re_m);
            if (re > 180) {
                System.out.println(360 - re);
            } else System.out.println(re);
        }
    }
}
