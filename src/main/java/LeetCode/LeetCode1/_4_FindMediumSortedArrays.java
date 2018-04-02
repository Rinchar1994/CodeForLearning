package main.java.LeetCode.LeetCode1;

/**
 * Created by Rinchar on 2017/9/29.
 */
public class _4_FindMediumSortedArrays {
    //4. Median of Two Sorted Arrays (Hard)
    //将找中位数转换成找第几小数的问题，再将其规划到找最小数的问题
    public double findMediumSortedArrays(int[] nums1, int[] nums2) {
        int len_sum = nums1.length + nums2.length;
        if (len_sum % 2 == 1) {
            return (double) findKthSmall(nums1, 0, nums2, 0, (len_sum + 1) / 2);
        } else {
            double re1 = (double) findKthSmall(nums1, 0, nums2, 0, (len_sum + 1) / 2);
            double re2 = (double) findKthSmall(nums1, 0, nums2, 0, (len_sum + 1) / 2 + 1);
            return (re1 + re2) / 2;
        }
    }

    public int findKthSmall(int[] numSmall, int beginS, int[] numLarge, int beginL, int k) {
        if (numSmall.length > numLarge.length) {
            return findKthSmall(numLarge, beginL, numSmall, beginS, k);
        }
        if (numSmall.length == beginS) {
            return numLarge[beginL + k - 1];
        }
        if (numLarge.length == beginL) {
            return numSmall[beginS + k - 1];
        }
        if (k == 1) {
            return Math.min(numSmall[beginS], numLarge[beginL]);
        }
        int A = Math.min(k / 2, numSmall.length), B = k - A;
        if (numSmall[beginS + A - 1] == numLarge[beginL + B - 1]) {
            return numSmall[beginS + A - 1];
        } else if (numSmall[beginS + A - 1] < numLarge[beginL + B - 1]) {
            return findKthSmall(numSmall, beginS + A, numLarge, beginL, B);
        } else {
            return findKthSmall(numSmall, beginS, numLarge, beginL + B, A);
        }
    }
}
