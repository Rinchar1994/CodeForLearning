package main.java.LeetCode;

import main.java.LeetCodeUtil.ArrayPrint;

/**
 * Created by Rinchar on 2017/10/23.
 */
public class _41_FirstMissingPositive {
    //41. First Missing Positive (Hard) 90.07%
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) return 1;

        //把小于等于nums.length的正数nums[i]放到第nums[i]-1个位置上
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 0};
        firstMissingPositive(a);
        System.out.println(ArrayPrint.intArrPrint(a));
    }
}
