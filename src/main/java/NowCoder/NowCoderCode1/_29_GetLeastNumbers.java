package main.java.NowCoder.NowCoderCode1;

import java.util.ArrayList;

/**
 * Created by Rinchar on 2018/4/16.
 */
public class _29_GetLeastNumbers {
    //此方法适合用于海量数据
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input.length < k || k == 0) return new ArrayList<>();
        ArrayList<Integer> K = new ArrayList<>();
        for (int i = 0; i < k; i++) K.add(input[i]);
        for (int i = k / 2 - 1; i >= 0; i--) HeapAdjust(K, 0, k);
        for (int i = k; i < input.length; i++) {
            if (input[i] < K.get(0)) K.set(0, input[i]);
            HeapAdjust(K, 0, k);
        }
        return K;
    }

    public static void HeapAdjust(ArrayList<Integer> input, int parent, int len) {
        int child = parent * 2 + 1;
        while (child < len) {
            if (child + 1 < len && input.get(child) < input.get(child + 1)) child++;
            if (input.get(child) > input.get(parent)) {
                int temp = input.get(child);
                input.set(child, input.get(parent));
                input.set(parent, temp);
                parent = child;
                child = parent * 2 + 1;
            } else break;
        }
    }
}
