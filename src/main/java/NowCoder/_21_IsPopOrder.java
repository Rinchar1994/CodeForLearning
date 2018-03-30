package main.java.NowCoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2018/3/15.
 */
public class _21_IsPopOrder {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        ArrayList<Integer> stack = new ArrayList<>();
        if (pushA.length == 0) return true;
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            if (popA[j] == pushA[i]) {
                j++;
            } else {
                if (stack.indexOf(popA[j]) == -1) stack.add(pushA[i]);
                else if (stack.indexOf(popA[j]) == stack.size() - 1) {
                    stack.remove(stack.size() - 1);
                    j++;
                } else {
                    return false;
                }
            }
        }
        while (j < popA.length) {
            if (stack.indexOf(popA[j]) == stack.size() - 1) {
                stack.remove(stack.size() - 1);
                j++;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(push, pop));
    }
}
