package main.java.LeetCode.LeetCode2;

import main.java.LeetCode.LeetCodeUtil.ArrayPrint;

/**
 * Created by Rinchar on 2017/11/10.
 */
public class _75_SortColors {
    //75. Sort Colors (Medium) 4.38%
    public static void sortColors(int[] nums) {
        int head = 0, tail = nums.length - 1;
        if (nums.length == 0) return;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                if (i >= tail) break;
                int temp = nums[tail];
                nums[tail] = nums[i];
                nums[i] = temp;
                tail--;
                i--;
            } else if (nums[i] == 0) {
                if (i <= head) continue;
                int temp = nums[head];
                nums[head] = nums[i];
                nums[i] = temp;
                head++;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 0, 1, 2};
        sortColors(a);
        System.out.println(ArrayPrint.intArrPrint(a));
    }
}
