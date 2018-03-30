package main.java.LeetCode;

import main.java.LeetCodeUtil.ArrayPrint;

/**
 * Created by Rinchar on 2017/10/16.
 */
public class _27_RemoveElement {
    //27. Remove Element (Easy) 11.19%
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int re = 0;
        int head = 0, tail = nums.length - 1;
        while (head <= tail) {
            if (nums[head] == val) {
                re++;
                nums[head] = nums[tail];
                tail--;
                continue;
            }
            head++;
        }
        return nums.length - re;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 2};
        int val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(ArrayPrint.intArrPrint(nums));
    }
}
