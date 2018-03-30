package main.java.NowCoder;

import main.java.NowCoderUtil.TreeNode;

/**
 * Created by Rinchar on 2018/3/14.
 */
public class _18_Mirror {
    public static void Mirror(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
