package main.java.NowCoder.NowCoderCode1;

import java.util.ArrayList;

/**
 * Created by Rinchar on 2018/4/30.
 */
public class _42_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if(array.length == 0) return new ArrayList<>();
        ArrayList<Integer> re = new ArrayList<>();
        int head = 0, tail = array.length - 1;
        while (head < tail) {
            int temp = array[head] + array[tail];
            if (temp == sum) {
                re.add(array[head]);
                re.add(array[tail]);
                break;
            } else if(temp < sum) head++;
            else tail--;
        }
        return re;
    }
}
