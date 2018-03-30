package main.java.LeetCode;

/**
 * Created by Rinchar on 2017/10/16.
 */
public class _11_ContainerWithMostWater {
    //11. Container With Most Water (Medium) 77.35%
    public static int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int MaxArea = 0;
        int head = 0, tail = height.length - 1;
        while (head < tail) {
            int short_pos = height[head] < height[tail] ? head : tail;
            int tempArea = height[short_pos] * (tail - head);
            MaxArea = MaxArea < tempArea ? tempArea : MaxArea;
            if (short_pos == head) {
                head++;
            } else {
                tail--;
            }
        }
        return MaxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 1};
        System.out.println(maxArea(height));
    }
}
