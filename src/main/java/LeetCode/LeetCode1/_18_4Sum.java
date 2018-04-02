package main.java.LeetCode.LeetCode1;

import java.util.*;

/**
 * Created by Rinchar on 2017/10/17.
 */
public class _18_4Sum {
    //18. 4Sum (Medium) 51.90%
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> re = new ArrayList<>();
        if (nums.length < 4) {
            return re;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int head = j + 1, tail = nums.length - 1;
                int sum2 = nums[i] + nums[j];
                while (head < tail) {
                    if (sum2 + nums[head] + nums[tail] == target) {
                        re.add(Arrays.asList(nums[i], nums[j], nums[head], nums[tail]));
                        while (head < tail && nums[head] == nums[head + 1]) {
                            head++;
                        }
                        while (head < tail && nums[tail] == nums[tail - 1]) {
                            tail--;
                        }
                        head++;
                        tail--;
                    } else if (sum2 + nums[head] + nums[tail] > target) {
                        tail--;
                    } else {
                        head++;
                    }
                }
                while (j < nums.length - 3 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < nums.length - 4 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
}
