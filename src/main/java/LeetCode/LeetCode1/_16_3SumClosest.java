package main.java.LeetCode.LeetCode1;


import java.util.Arrays;

/**
 * Created by Rinchar on 2017/10/16.
 */
public class _16_3SumClosest {
    //16. 3Sum Closest (Medium) 26.50%
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sumClosest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            int head = i + 1, tail = nums.length - 1;
            while (head < tail) {
                int gap_temp = Math.abs(nums[i] + nums[head] + nums[tail] - target);
                int gap_min = Math.abs(sumClosest - target);
                if (gap_temp == 0) {
                    return target;
                }
                if (gap_min > gap_temp) {
                    sumClosest = nums[i] + nums[head] + nums[tail];
                }
                while (head < tail && nums[head] == nums[tail]) {
                    head++;
                }
                while (head < tail && nums[tail] == nums[tail - 1]) {
                    tail--;
                }
                if (nums[i] + nums[head] + nums[tail] > target) {
                    tail--;
                } else {
                    head++;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return sumClosest;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -2, -5, 3, -4};
        int tar = -1;
        System.out.println(threeSumClosest(nums, tar));
    }
}
