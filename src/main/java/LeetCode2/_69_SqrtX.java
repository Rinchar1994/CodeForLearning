package main.java.LeetCode2;

/**
 * Created by Rinchar on 2017/11/8.
 */
public class _69_SqrtX {
    //69. Sqrt(x) (Easy) 5.45%
    public static int mySqrt(int x) {
        int head = 1, tail = x;
        int re = 0;
        while (head <= tail) {
            int mid = (tail + head) / 2;
            if (mid <= x / mid) {
                head = mid + 1;
                re = mid;
            } else {
                tail = mid - 1;
            }
        }
        return re;
    }
}
