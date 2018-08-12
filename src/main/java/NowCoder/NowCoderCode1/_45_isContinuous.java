package main.java.NowCoder.NowCoderCode1;

import java.util.Arrays;

/**
 * Created by Rinchar on 2018/4/30.
 */
public class _45_isContinuous {
    public static boolean isContinuous(int [] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int num_zero = 0, gap = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                num_zero++;
                continue;
            }
            if(numbers[i] == numbers[i+1]) return false;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] == 0) continue;
            gap += numbers[i + 1] == numbers[i] ? 0 : numbers[i + 1] - numbers[i] - 1;
        }

        if (gap > num_zero) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] temp = {1, 3, 0, 5, 0};
        System.out.println(isContinuous(temp));
    }
}
