package main.java.ShiXiBiShi._58ShiXi;

/**
 * Created by Rinchar on 2018/4/1.
 */
public class _2 {
    public static int getInfoMaxScore(int[] scoreArr) {
        int nall;
        int nstart;
        nall = nstart = scoreArr[0];
        for(int i = 1; i < scoreArr.length; i++)
        {
            nstart = Math.max(nstart + scoreArr[i], scoreArr[i]);
            nall = Math.max(nstart, nall);
        }
        return nall;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, -1, -10, 11, 4, -6, 9, 20, -10, -2};
        System.out.println(getInfoMaxScore(a));
    }
}
