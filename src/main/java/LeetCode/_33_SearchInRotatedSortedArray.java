package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/10/22.
 */
public class _33_SearchInRotatedSortedArray {
    //33. Search in Rotated Sorted Array (Medium) 30.44%
    public int search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) return i;
        }
        return -1;
    }
}
