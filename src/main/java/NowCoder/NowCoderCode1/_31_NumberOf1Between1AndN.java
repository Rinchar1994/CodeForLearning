package main.java.NowCoder.NowCoderCode1;

import java.util.ArrayList;

/**
 * Created by Rinchar on 2018/4/17.
 */
public class _31_NumberOf1Between1AndN {
    public static int NumberOf1Between1AndN_Solution(int n) {
        ArrayList<Integer> num = new ArrayList<>();
        if (n == 0) return 0;
        while (n > 0) {
            num.add(n % 10);
            n /= 10;
        }
        return NumberOfSubN(num, num.size() - 1);
    }

    public static int NumberOfSubN(ArrayList<Integer> num, int pos) {
        if (pos == 0) return num.get(pos) == 0 ? 0 : 1;
        int re = 0;
        if (num.get(pos) != 0) {
            re = num.get(pos) * pos * pow10(pos - 1);
            if (num.get(pos) == 1) re += subN(num, pos - 1) + 1;
            else re += pow10(pos);
        }
        return re + NumberOfSubN(num, pos - 1);
    }

    public static int pow10(int pos) {
        int re = 1;
        while (pos-- > 0) {
            re *= 10;
        }
        return re;
    }

    public static int subN(ArrayList<Integer> num, int pos) {
        int re = 0;
        for (int i = pos; i >= 0; i--) {
            re = re * 10 + num.get(i);
        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(55));
    }
}
