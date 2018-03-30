package main.java.LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Rinchar on 2017/10/24.
 */
public class _46_Permutations {
    //46. Permutations (Medium) 45.62%
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        re.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> re_dup = new ArrayList<>();
            re_dup.addAll(re);
            for (List<Integer> list : re_dup) {
                for (int j = 0; j <= list.size(); j++) {
                    List<Integer> list_dup = new ArrayList<>();
                    list_dup.addAll(list);
                    list_dup.add(j, nums[i]);
                    re.add(list_dup);
                }
                re.remove(list);
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
