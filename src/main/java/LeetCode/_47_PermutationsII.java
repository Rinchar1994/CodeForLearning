package main.java.LeetCode;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rinchar on 2017/10/24.
 */
public class _47_PermutationsII {
    //47. Permutations II (Medium) 8.74%
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> re = new HashSet<>();
        re.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            Set<List<Integer>> re_dup = new HashSet<>();
            re_dup.addAll(re);
            for (List<Integer> list : re_dup) {
                for (int j = 0; j <= list.size(); j++) {
                    if (j < list.size() && nums[i] == list.get(j)) continue;
                    List<Integer> list_dup = new ArrayList<>();
                    list_dup.addAll(list);
                    list_dup.add(j, nums[i]);
                    re.add(list_dup);
                }
                re.remove(list);
            }
        }
        List<List<Integer>> relist = new ArrayList<>();
        relist.addAll(re);
        return relist;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2};
        System.out.println(permuteUnique(nums));
    }
}
