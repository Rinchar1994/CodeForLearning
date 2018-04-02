package main.java.NowCoder.NowCoderCode;

import main.java.NowCoder.NowCoderUtil.TreeNode;

/**
 * Created by Rinchar on 2018/3/14.
 */
public class _17_HasSubtree {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null) return false;
        if(root2 == null) return false;
        return isSubtree(root1, root2)
                || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public static boolean isSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        else if(root2 == null && root1 != null) return false;
        else if(root1 == null && root2 != null) return false;
        if(root1.val != root2.val) return false;
        if(root2.left == null && root2.right == null) return true;
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }
}
