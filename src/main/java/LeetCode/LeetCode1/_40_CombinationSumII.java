package main.java.LeetCode.LeetCode1;


import java.util.*;

/**
 * Created by Rinchar on 2017/10/23.
 */
public class _40_CombinationSumII {
    //40 Combination Sum II (Medium) 8.30%
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> dp = new ArrayList<>();
        Map<Integer, Integer> candMap = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if(candMap.containsKey(candidates[i])) candMap.put(candidates[i], candMap.get(candidates[i]) + 1);
            else candMap.put(candidates[i], 1);
        }
        for (int i = 1; i <= target; i++) {
            Set<List<Integer>> subCand = new HashSet<>();
            for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                if (candidates[j] == i) subCand.add(Arrays.asList(i));
                else for (List<Integer> l : dp.get(i - 1 - candidates[j])) {
                    if (candidates[j] <= l.get(0)) {
                        List<Integer> cl = new ArrayList<>();
                        cl.add(candidates[j]);
                        cl.addAll(l);
                        int cnt = 1;
                        for (int a : l) {
                            if(a == candidates[j]) cnt++;
                            else break;
                        }
                        if(cnt <= candMap.get(candidates[j])) subCand.add(cl);
                    }
                }
            }
            List<List<Integer>> subCandList = new ArrayList<>();
            subCandList.addAll(subCand);
            dp.add(subCandList);
        }
        return dp.get(target - 1);
    }

    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        /*List<Integer> t1 = Arrays.asList(10, 1, 2, 7, 6, 1, 5);
        List<Integer> t2 = Arrays.asList(1, 1, 1);
        System.out.println(t1.containsAll(t2));*/
        int tar = 8;
        System.out.println(combinationSum2(a, tar));
    }
}
