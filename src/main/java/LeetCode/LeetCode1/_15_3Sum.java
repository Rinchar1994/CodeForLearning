package main.java.LeetCode.LeetCode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rinchar on 2017/10/16.
 */
public class _15_3Sum {
    //15. 3Sum (Medium) 76.81%
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        if (nums.length < 3) {
            return re;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int head = i + 1, tail = nums.length - 1;
            int neg = 0 - nums[i];
            while (head < tail) {
                if (nums[head] + nums[tail] == neg) {
                    re.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {
                        tail--;
                    }
                    head++; tail--;
                } else if (nums[head] + nums[tail] < neg) {
                    head++;
                } else {
                    tail--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
