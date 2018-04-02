package main.java.LeetCode.LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rinchar on 2017/11/14.
 */
public class _78_Subsets {
    //78. Subsets (Medium) 3.21%
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        Arrays.sort(nums);
        subsetsBack(re, nums, 0);
        return re;
    }

    public static void subsetsBack(List<List<Integer>> re, int[] nums, int i) {
        if (i > nums.length) return;
        if (i == 0) {
            re.add(new ArrayList<Integer>());
        }
        if (i == 1) {
            for (int t = 0; t < nums.length; t++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[t]);
                re.add(temp);
            }
        } else {
            for (int t = re.size() - 1; re.get(t).size() == i - 1; t--) {
                List<Integer> index = new ArrayList<>();
                index.add(re.get(t).get(i - 2));
                for (int x = re.indexOf(index); x < nums.length; x++) {
                    List<Integer> tempSub = new ArrayList<>();
                    tempSub.addAll(re.get(t));
                    tempSub.add(nums[x]);
                    re.add(tempSub);
                }
            }
        }
        subsetsBack(re, nums, i + 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(subsets(a));
    }
}
