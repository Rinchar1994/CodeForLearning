package main.java.LeetCode.LeetCode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rinchar on 2017/10/22.
 */
public class _39_CombinationSum {
    //39. Combination Sum (Medium) 11.52%
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            List<List<Integer>> subCand = new ArrayList<>();
            for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                if (i == candidates[j]) subCand.add(Arrays.asList(candidates[j]));
                else for (List<Integer> l : dp.get(i - candidates[j] - 1)) {
                    if (candidates[j] <= l.get(0)) {
                        List<Integer> cl = new ArrayList<>();
                        cl.add(candidates[j]);
                        cl.addAll(l);
                        subCand.add(cl);
                    }
                }
            }
            dp.add(subCand);
        }
        return dp.get(target - 1);
    }

    public static void main(String[] args) {
        int[] cand = {2, 3, 6, 7};
        int tar = 7;
        System.out.println(combinationSum(cand, tar));
    }
}
