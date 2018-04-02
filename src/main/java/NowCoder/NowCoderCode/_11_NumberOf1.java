package main.java.NowCoder.NowCoderCode;

/**
 * Created by Rinchar on 2018/3/9.
 */
public class _11_NumberOf1 {
    public static int NumberOf1(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            result += n & 1;
            n >>= 1;
        }
        return result;
    }
}
