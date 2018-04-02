package main.java.NowCoder.NowCoderCode;

/**
 * Created by Rinchar on 2018/3/9.
 */
public class _6_MinNumberInRotateArray {
    public static int minNumberInRotateArray(int[] array) {
        /*if (array.length == 0) return 0;
        int min = array[array.length - 1];
        for (int key = array.length - 2; key >= 0; key--) {
            if (array[key] > min) break;
            min = array[key];
        }
        return min;*/
        if (array.length == 0) return 0;
        int low = 0, hi = array.length - 1, mid = 0;
        if (low == hi || array[low] < array[hi]) {
            return array[low];
        }
        while (low < hi) {
            mid = (low + hi) / 2;
            if (mid == low) {
                mid = hi;
                break;
            }
            if (array[mid] >= array[low]) {
                low = mid;
            } else {
                hi = mid;
            }
        }
        return array[mid];
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        System.out.println(minNumberInRotateArray(a));
    }
}
