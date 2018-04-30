package main.java.NowCoder.NowCoderCode1;

import main.java.NowCoder.NowCoderUtil.TreeNode;

/**
 * Created by Rinchar on 2018/4/30.
 */
public class _39_IsBalanced_Solution {
    boolean IsBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return IsBalanced;
    }

    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        if(!IsBalanced) return -1;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            IsBalanced = false;
            return -1;
        }
        return right > left ? (right + 1) : (left + 1);
    }
}
