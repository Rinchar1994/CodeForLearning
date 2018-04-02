package main.java.LeetCode.LeetCode2;

/**
 * Created by Rinchar on 2017/10/27.
 */
public class _55_JumpGame {
    //55. Jump Game (Medium) 66.39%
    public static boolean canJump(int[] nums) {
        int tail = nums.length - 1, tail_dup = tail;
        for (; tail > 0; tail--) {
            tail_dup = tail;
            while (--tail_dup >= 0) {
                if (tail - tail_dup <= nums[tail_dup]) {
                    tail = tail_dup + 1;
                    break;
                }
            }
            if (tail_dup == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}
