package main.java.LeetCode.LeetCode2;

import main.java.LeetCode.LeetCodeUtil.TreeNode;

/**
 * Created by Rinchar on 2017/10/26.
 */
public class _100_SameTree {
    //100. Same Tree (Easy) 12.33%
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null || p.val != q.val) return false;
        else {
            if (!isSameTree(p.left, q.left)) return false;
            if (!isSameTree(p.right, q.right)) return false;
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
