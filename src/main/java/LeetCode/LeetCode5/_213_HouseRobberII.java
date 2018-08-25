package main.java.LeetCode.LeetCode5;

/**
 * @author: Rinchar
 * @date: 2018/8/25
 **/
public class _213_HouseRobberII {
    // 231. HouseRobberII (Medium 7.03%)
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(houseRobber(nums, 0, nums.length - 2), houseRobber(nums, 1, nums.length - 1));
    }

    private int houseRobber(int[] nums, int low, int high) {
        int prev2 = 0, prev = nums[low];
        for (int i = low + 1; i <= high; i++) {
            int temp = Math.max(prev2 + nums[i], prev);
            prev2 = prev;
            prev = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        _213_HouseRobberII sample = new _213_HouseRobberII();
        int[] nums = {2,3,2};
        System.out.println(sample.rob(nums));
    }
}
