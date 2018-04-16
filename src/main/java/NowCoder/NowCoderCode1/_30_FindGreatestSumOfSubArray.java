package main.java.NowCoder.NowCoderCode1;

/**
 * Created by Rinchar on 2018/4/16.
 */
public class _30_FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) return 0;
        int maxSum = Integer.MIN_VALUE, tempSum = 0;
        for (int i = 0; i < array.length; i++) {
            tempSum += array[i];
            if (maxSum < tempSum) maxSum = tempSum;
            if (tempSum < 0) tempSum = 0;
        }
        return maxSum;
    }
}
