package main.java.NowCoder.NowCoderCode;

/**
 * Created by Rinchar on 2018/3/9.
 */
public class _6_MinNumberInRotateArray {
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int min = array[array.length - 1];
        for (int key = array.length - 2; key >= 0; key--) {
            if (array[key] > min) break;
            min = array[key];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        System.out.println(minNumberInRotateArray(a));
    }
}
