package main.java.algorithm;

/**
 * Created by Rinchar on 2018/4/2.
 */
public class binarySearch {
    public static int binarySearch(int[] arr, int n) {
        if (arr.length <= 0) return -1;
        int low = 0, hi = arr.length - 1, mid;
        while (low <= hi) {
            mid = (low + hi) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] > n) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8};
        int n = 5;
        System.out.println(binarySearch(arr, n));
    }
}
