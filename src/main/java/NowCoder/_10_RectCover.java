package main.java.NowCoder;

/**
 * Created by Rinchar on 2018/3/9.
 */
public class _10_RectCover {
    public static int RectCover(int target) {
        if (target <= 2) return target;
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
