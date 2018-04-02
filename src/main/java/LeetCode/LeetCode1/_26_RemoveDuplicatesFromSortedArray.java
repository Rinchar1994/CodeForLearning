package main.java.LeetCode.LeetCode1;

import java.util.Arrays;

/**
 * Created by Rinchar on 2017/10/19.
 */
public class _26_RemoveDuplicatesFromSortedArray {
    //26. Remove Duplicates from Sorted Array (Easy) 21.72%
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[j]) nums[++j] = nums[i];
        }
        return ++j;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
}
