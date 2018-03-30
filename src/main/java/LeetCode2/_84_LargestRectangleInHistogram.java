package main.java.LeetCode2;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Rinchar on 2017/11/16.
 */
public class _84_LargestRectangleInHistogram {
    //84. Largest Rectangle in Histogram (Hard) 77.80%
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int areaMax = 0, bottomStack = -1;
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            if (i == 0) indexStack.push(i);
            else {
                if (heights[i - 1] <= heights[i]) indexStack.push(i);
                else {
                    while (indexStack.peek() != -1 && heights[indexStack.peek()] > heights[i]) {
                        int indexTemp = indexStack.peek();
                        areaMax = Math.max(areaMax, (heights[indexTemp] * (i - indexTemp)));
                        if (indexTemp == 0) heights[0] = heights[i];
                        else indexStack.pop();
                        if (heights[indexStack.peek()] <= heights[i]) {
                            heights[indexTemp] = heights[i];
                            indexStack.push(indexTemp);
                        }
                    }
                    indexStack.push(i);
                }
            }
        }
        while (indexStack.peek() != -1) {
            int indexTemp = indexStack.peek();
            areaMax = Math.max(areaMax, (heights[indexTemp] * (heights.length - indexTemp)));
            indexStack.pop();
        }
        return areaMax;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 0, 3, 2, 5};
        System.out.println(largestRectangleArea(a));
    }
}
