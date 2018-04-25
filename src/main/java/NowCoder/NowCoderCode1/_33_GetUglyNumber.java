package main.java.NowCoder.NowCoderCode1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Rinchar on 2018/4/17.
 */
public class _33_GetUglyNumber {
    public static int GetUglyNumber_Solution(int index) {
        int pos_2, pos_3, pos_5;
        if (index <= 0) return 0;
        int[] uglyNum = new int[index];
        uglyNum[0] = 1;
        pos_2 = 0;
        pos_3 = 0;
        pos_5 = 0;
        for (int i = 1; i < index; i++) {
            int temp_2 = uglyNum[pos_2] * 2, temp_3 = uglyNum[pos_3] * 3, temp_5 = uglyNum[pos_5] * 5;
            switch (minOf3(temp_2, temp_3, temp_5)) {
                case 0:
                    uglyNum[i] = temp_2;
                    break;
                case 1:
                    uglyNum[i] = temp_3;
                    break;
                case 2:
                    uglyNum[i] = temp_5;
                    break;
                default:
                    break;
            }
            int temp = uglyNum[i];
            while (uglyNum[pos_2] * 2 <= temp) pos_2++;
            while (uglyNum[pos_3] * 3 <= temp) pos_3++;
            while (uglyNum[pos_5] * 5 <= temp) pos_5++;
        }
        return uglyNum[index - 1];
    }

    public static int minOf3(int a, int b, int c) {
        if (a <= b && a <= c) return 0;
        else if (b <= a && b <= c) return 1;
        else return 2;
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(7));
    }
}
