package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/10/22.
 */
public class _34_SearchForARange {
    //34. Search for a Range (Medium) 13.25%
    public static int[] searchRange(int[] nums, int target) {
        int[] re = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (re[0] == -1) re[0] = i;
                if (i + 1 == nums.length || nums[i + 1] != target) re[1] = i;
            }
        }
        return re;
    }
}
