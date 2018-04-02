package main.java.LeetCode.LeetCode2;

/**
 * Created by Rinchar on 2017/11/7.
 */
public class _66_PlusOne {
    //66. Plus One (Easy) 27.06%
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len - 1]++;
        for (int i = len - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1]++;
            } else break;
        }
        if (digits[0] == 10) {
            int[] re = new int[len + 1];
            re[0] = 1;
            return re;
        }
        return digits;
    }
}
