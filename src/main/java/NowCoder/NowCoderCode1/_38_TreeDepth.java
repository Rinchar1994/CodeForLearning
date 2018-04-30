package main.java.NowCoder.NowCoderCode1;

import main.java.NowCoder.NowCoderUtil.TreeNode;

/**
 * Created by Rinchar on 2018/4/30.
 */
public class _38_TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return right > left ? (right + 1) : (left + 1);
    }
}
