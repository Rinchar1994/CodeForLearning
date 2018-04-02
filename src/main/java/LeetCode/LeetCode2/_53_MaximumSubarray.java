package main.java.LeetCode.LeetCode2;

/**
 * Created by Rinchar on 2017/10/26.
 */
public class _53_MaximumSubarray {
    //53. Maximum Subarray (Easy) 18.79%
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {8, -19, 5, -4, 20};
        System.out.println(maxSubArray(nums));
    }
}
