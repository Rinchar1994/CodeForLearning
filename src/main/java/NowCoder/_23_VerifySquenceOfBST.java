package main.java.NowCoder;

/**
 * Created by Rinchar on 2018/3/16.
 */
public class _23_VerifySquenceOfBST {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        int root = sequence[sequence.length - 1];
        int line = 0;
        for (; line < sequence.length - 1; line++) {
            if (sequence[line] > root) break;
        }
        for (int j = line; j < sequence.length - 1; j++) {
            if (sequence[j] < root) return false;
        }
        return isSquenceOfBST(sequence, 0, line)
                && isSquenceOfBST(sequence, line, sequence.length - 1);
    }

    public static boolean isSquenceOfBST(int[] sequence, int lo, int hi) {
        if (hi - lo <= 1) return true;
        int root = sequence[hi - 1];
        int line = lo;
        for (; line < hi - 1; line++) {
            if (sequence[line] > root) break;
        }
        for (int j = line; j < hi - 1; j++) {
            if (sequence[j] < root) return false;
        }
        return isSquenceOfBST(sequence, lo, line)
                && isSquenceOfBST(sequence, line, hi - 1);
    }

    public static void main(String[] args) {
        int[] a = {7, 4, 6, 5};
        System.out.println(VerifySquenceOfBST(a));
    }
}
