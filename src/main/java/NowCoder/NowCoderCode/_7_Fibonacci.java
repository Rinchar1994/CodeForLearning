package main.java.NowCoder.NowCoderCode;

/**
 * Created by Rinchar on 2018/3/9.
 */
public class _7_Fibonacci {
    public static int Fibonacci(int n) {
        if (n <= 1) return n;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }
}
