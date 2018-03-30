package main.java.LeetCode2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2017/11/14.
 */
public class _77_Combinations {
    //77, Combinations (Medium) 86.24%
    public static List<List<Integer>> combine(int n, int k) {
        if (n < 0 || k > n) return new ArrayList<>();
        List<List<Integer>> re = new ArrayList<>();
        combineBack(re, n, k, 1);
        return re;
    }

    public static void combineBack(List<List<Integer>> re, int n, int k, int i) {
        if (i > k) return;
        if (i == 1) {
            for (int t = 1; t <= n - k + 1; t++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(t);
                re.add(temp);
            }
        } else {
            for (int t = re.size() - 1; t >= 0; t--) {
                for (int x = re.get(t).get(i - 2) + 1; x <= n - k + i; x++) {
                    List<Integer> tempSub = new ArrayList<>();
                    tempSub.addAll(re.get(t));
                    tempSub.add(x);
                    re.add(tempSub);
                }
                re.remove(t);
            }
        }
        combineBack(re, n, k, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(combine(5, 3));
    }
}