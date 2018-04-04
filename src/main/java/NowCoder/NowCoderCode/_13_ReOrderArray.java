package main.java.NowCoder.NowCoderCode;

import main.java.LeetCode.LeetCodeUtil.ArrayPrint;

/**
 * Created by Rinchar on 2018/3/13.
 */
public class _13_ReOrderArray {
    public static void reOrderArray(int[] array) {
        //注释掉的代码不能实现重排之后的奇数之间顺序不变
        /*int lo = 0, hi = array.length - 1;
        while (lo < hi) {
            while (array[lo] % 2 == 1) lo++;
            while (array[hi] % 2 == 0) hi--;
            if (lo < hi) {
                int temp = array[lo];
                array[lo] = array[hi];
                array[hi] = temp;
            }
        }*/
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] % 2 == 1 && array[i - 1] % 2 == 0) {
                for (int j = i; j > 0; j--) {
                    if (array[j - 1] % 2 == 0) {
                        int temp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        reOrderArray(a);
        System.out.println(ArrayPrint.intArrPrint(a));
    }
}
