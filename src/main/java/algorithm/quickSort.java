package main.java.algorithm;


import main.java.LeetCode.LeetCodeUtil.ArrayPrint;

/**
 * Created by Rinchar on 2018/3/15.
 */
public class quickSort {
    public static void quickSort(int[] temple, int lo, int hi) {
        if (hi <= lo) return;
        int pos = quickSortDesign(temple, lo, hi);
        quickSort(temple, lo, pos - 1);
        quickSort(temple, pos + 1, hi);
    }

    public static int quickSortDesign(int[] temple, int lo, int hi) {
        int key = temple[lo], temp;
        while (lo < hi) {
            while (temple[hi] >= key && hi > lo) hi--;
            temple[lo] = temple[hi];
            while (temple[lo] <= key && hi > lo) lo++;
            temple[hi] = temple[lo];
        }
        temple[hi] = key;
        return hi;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 2, 7, 6, 5};
        quickSort(a, 0, a.length - 1);
        System.out.println(ArrayPrint.intArrPrint(a));
    }
}
