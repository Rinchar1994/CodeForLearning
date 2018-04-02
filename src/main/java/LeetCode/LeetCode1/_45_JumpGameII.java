package main.java.LeetCode.LeetCode1;

/**
 * Created by Rinchar on 2017/10/24.
 */
public class _45_JumpGameII {
    //45. Jump Game II (Hard) 3.98%
    public static int jump(int[] nums) {
        int tail = nums.length - 1, head = tail;
        int cnt = 0;
        while (head > 0) {
            for(int i = 0; i<tail; i++) {
                if (nums[i] >= tail - i) {
                    head = i;
                    break;
                }
            }
            if(head == 0) return ++cnt;
            tail = head;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {};
        System.out.println(jump(a));
    }
}
