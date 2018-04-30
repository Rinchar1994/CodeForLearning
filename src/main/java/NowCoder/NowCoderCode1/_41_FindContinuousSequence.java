package main.java.NowCoder.NowCoderCode1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2018/4/30.
 */
public class _41_FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        int num = 1, half = (sum + 1) / 2, subSum = 0;
        while (num <= half) {
            list.add(num);
            subSum += num;
            if (subSum == sum) {
                if (list.size() > 1) re.add(new ArrayList<Integer>(list));
            } else if (subSum > sum) {
                while (subSum > sum) {
                    subSum -= list.get(0);
                    list.remove(0);
                    if(subSum == sum) re.add(new ArrayList<Integer>(list));
                }
            }
            num++;
        }
        return re;
    }

    public static void main(String[] args) {
        FindContinuousSequence(9);
    }
}
