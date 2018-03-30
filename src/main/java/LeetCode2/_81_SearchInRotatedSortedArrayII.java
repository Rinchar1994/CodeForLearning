package main.java.LeetCode2;

/**
 * Created by Rinchar on 2017/11/15.
 */
public class _81_SearchInRotatedSortedArrayII {
    //81. Search in Rotated Sorted Array II (Medium) 9.44%
    public static boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return true;
        }
        return false;
    }
}
