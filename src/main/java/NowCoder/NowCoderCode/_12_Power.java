package main.java.NowCoder.NowCoderCode;

/**
 * Created by Rinchar on 2018/3/12.
 */
public class _12_Power {
    public static double Power(double base, int exponent) {
        int ex = exponent < 0 ? -exponent : exponent;
        double result = 1;
        while (ex != 0) {
            result *= ((ex & 1) == 1) ? base : 1;
            ex >>= 1;
            base *= base;
        }
        return exponent < 0 ? 1 / result : result;
    }

    public static void main(String[] args) {
        System.out.println(Power(2.0, 2));
    }
}
