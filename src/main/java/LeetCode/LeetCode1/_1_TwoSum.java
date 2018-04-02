package main.java.LeetCode.LeetCode1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rinchar on 2017/9/29.
 */
public class _1_TwoSum {
    //1.Two Sum (Easy)  Time:O(n) HashMap's Time is 0(1)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                result[0] = numMap.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            numMap.put(nums[i], i);
        }
        return result;
    }
}
