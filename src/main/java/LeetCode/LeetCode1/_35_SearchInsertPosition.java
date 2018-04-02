package main.java.LeetCode.LeetCode1;

/**
 * Created by Rinchar on 2017/10/22.
 */
public class _35_SearchInsertPosition {
    //35. Search Insert Position (Easy) 15.33%
    public static int searchInsert(int[] nums, int target) {
        int[] temp = new int[nums.length + 2];
        temp[0] = Integer.MIN_VALUE;
        temp[temp.length - 1] = Integer.MAX_VALUE;
        for (int i = 1; i < temp.length - 1; i++) temp[i] = nums[i - 1];
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == target) return i - 1;
            if (temp[i] > target && temp[i - 1] < target) return i - 1;
        }
        return 1;
    }
}
