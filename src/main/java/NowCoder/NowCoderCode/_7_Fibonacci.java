package main.java.NowCoder.NowCoderCode;

/**
 * Created by Rinchar on 2018/3/9.
 */
public class _7_Fibonacci {
    public static int Fibonacci(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;
        int slow = 1, fast = 1;
        for (int i = 3; i <= n; i++) {
            int temp = fast;
            fast += slow;
            slow = temp;
        }
        return fast;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }
}
