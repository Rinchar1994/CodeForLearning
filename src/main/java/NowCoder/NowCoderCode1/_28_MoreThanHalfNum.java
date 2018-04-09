package main.java.NowCoder.NowCoderCode1;

/**
 * Created by Rinchar on 2018/4/9.
 */
public class _28_MoreThanHalfNum {
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) return 0;
        int lo = 0, hi = array.length - 1;
        int base = array.length / 2;
        int re = quicksort(array, lo, hi, base);
        if (isTrue(re, array)) {
            return re;
        } else return 0;
    }

    public static int quicksort(int[] array, int low, int high, int base) {
        int lo = low, hi = high;
        int key = array[base + low], temp = 0;
        while (lo < hi) {
            while (lo < hi && array[lo] <= key) lo++;
            temp = array[lo];
            array[lo] = array[hi];
            array[hi] = temp;
            while (lo < hi && array[hi] >= key) hi--;
            temp = array[lo];
            array[lo] = array[hi];
            array[hi] = temp;
        }
        if (hi > base + low) return quicksort(array, low, hi - 1, base);
        else if (hi < base + low) return quicksort(array, hi + 1, high, base + low - hi - 1);
        else return array[hi];
    }

    public static boolean isTrue(int re, int[] array) {
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == re) times++;
        }
        if (times > array.length / 2) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        int re = _28_MoreThanHalfNum.MoreThanHalfNum_Solution(a);
        System.out.println(re);
    }
}
