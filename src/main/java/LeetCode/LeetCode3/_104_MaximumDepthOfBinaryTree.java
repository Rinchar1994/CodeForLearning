package main.java.LeetCode.LeetCode3;

import main.java.LeetCode.LeetCodeUtil.TreeNode;

/**
 * Created by Rinchar on 2018/3/6.
 */
public class _104_MaximumDepthOfBinaryTree {
    // 104. Maximum Depth of Binary Tree (Easy)
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth_left = maxDepth(root.left) + 1;
        int depth_right = maxDepth(root.right) + 1;
        return Math.max(depth_left, depth_right);
    }
}
