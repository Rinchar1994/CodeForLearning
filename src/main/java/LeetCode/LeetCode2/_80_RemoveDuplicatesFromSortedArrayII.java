package main.java.LeetCode.LeetCode2;

import main.java.LeetCode.LeetCodeUtil.ArrayPrint;

import java.util.Arrays;

/**
 * Created by Rinchar on 2017/11/15.
 */
public class _80_RemoveDuplicatesFromSortedArrayII {
    //80. Remove Duplicates from Sorted Array II (Medium) 4.97%
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int maxNum = nums[nums.length - 1];
        int cntTime = 1;
        int cntMax = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == maxNum) cntMax++;
        }
        cntMax = cntMax > 2 ? 2 : cntMax;
        for (int i = 1; i < nums.length; i++) {
            if (cntTime >= 2) {
                if (nums[i] == nums[i - cntTime + 1]) {
                    nums[i] = maxNum;
                    cntTime++;
                } else {
                    cntTime = 1;
                }
            } else {
                if (nums[i] == nums[i - 1]) cntTime++;
            }
        }
        Arrays.sort(nums);
        int cntNewMax = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == maxNum) cntNewMax++;
        }
        return nums.length - cntNewMax + cntMax;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 3, 3};
        System.out.println(removeDuplicates(a));
        System.out.println(ArrayPrint.intArrPrint(a));
    }
}
