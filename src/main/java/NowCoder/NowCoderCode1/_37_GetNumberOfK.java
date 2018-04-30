package main.java.NowCoder.NowCoderCode1;

/**
 * Created by Rinchar on 2018/4/30.
 */
public class _37_GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0) return 0;
        int first = GetFirstK(array, k, 0, array.length - 1);
        if (first == -1) return 0;
        int last = GetLastK(array, k, 0, array.length - 1);
        return last - first + 1;
    }

    public static int GetFirstK(int[] array, int k, int begin, int end) {
        int mid = (begin + end) / 2;
        if (end == begin) return k == array[begin] ? begin : -1;
        if (array[mid] > k) {
            return GetFirstK(array, k, begin, mid - 1);
        } else if (array[mid] < k) {
            return GetFirstK(array, k, mid + 1, end);
        } else {
            if (mid == 0 || array[mid - 1] < k) return mid;
            return GetFirstK(array, k, begin, mid - 1);
        }
    }

    public static int GetLastK(int[] array, int k, int begin, int end) {
        int mid = (begin + end) / 2;
        if (end == begin) return k == array[begin] ? begin : -1;
        if (array[mid] > k) {
            return GetLastK(array, k, begin, mid - 1);
        } else if (array[mid] < k) {
            return GetLastK(array, k, mid + 1, end);
        } else {
            if (mid == array.length - 1 || array[mid + 1] > k) return mid;
            return GetLastK(array, k, mid + 1, end);
        }
    }
}
