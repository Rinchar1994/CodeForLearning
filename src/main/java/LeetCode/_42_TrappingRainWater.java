package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/10/16.
 */
public class _42_TrappingRainWater {
    //42. Trapping Rain Water (Hard) 18.95%
    public static int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int re = 0;
        int head = 0, tail = height.length - 1;
        int sumBar = 0, sumBarWater = 0, cnt = 0;
        for(int i = 0; i < height.length; i++) {
            sumBar += height[i];
        }
        while (head <= tail) {
            int shortBar = height[head] < height[tail] ? head : tail;
            if (height[shortBar] > cnt) {
                sumBarWater += (height[shortBar] - cnt) * (tail - head + 1);
                cnt = height[shortBar];
            }
            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        return sumBarWater - sumBar;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
