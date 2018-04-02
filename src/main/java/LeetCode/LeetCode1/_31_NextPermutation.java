package main.java.LeetCode.LeetCode1;

import main.java.LeetCode.LeetCodeUtil.ArrayPrint;

/**
 * Created by Rinchar on 2017/10/22.
 */
public class _31_NextPermutation {
    //31. Next Permutation (Medium) 23.98%
    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                quiksort(nums, i, nums.length - 1);
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        break;
                    }
                }
                return;
            }
        }
        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            int temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            head++;
            tail--;
        }
    }

    public static void quiksort(int[] nums, int begin, int end) {
        if (begin >= end || nums == null) return;
        int p = partition(nums, begin, end);
        quiksort(nums, begin, p - 1);
        quiksort(nums, p + 1, end);
    }

    public static int partition(int[] nums, int begin, int end) {
        int key = nums[begin];
        int head = begin, tail = end;
        while (head < tail) {
            while (nums[tail] >= key && tail > head) tail--;
            if (tail == head) return head;
            if (nums[tail] < key) {
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
            }
            while (nums[head] <= key && tail > head) head++;
            if (head == tail) return tail;
            if (nums[head] > key) {
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 7, 5, 4, 3, 2, 2, 1};
        nextPermutation(nums);
        System.out.println(ArrayPrint.intArrPrint(nums));
    }
}
