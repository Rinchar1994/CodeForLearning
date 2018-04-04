package main.java.NowCoder.NowCoderCode;

/**
 * Created by Rinchar on 2018/3/9.
 */
public class _10_RectCover {
    public static int RectCover(int target) {
        if (target <= 2) return target;
        int slow = 1, fast = 2, temp;
        for(int i = 3; i <= target; i++) {
            temp = fast;
            fast += slow;
            slow = temp;
        }
        return fast;
    }
}
