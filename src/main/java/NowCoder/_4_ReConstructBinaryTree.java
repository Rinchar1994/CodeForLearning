package main.java.NowCoder;

import main.java.NowCoderUtil.TreeNode;

/**
 * Created by Rinchar on 2018/3/8.
 */
public class _4_ReConstructBinaryTree {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode head = null;
        if (pre.length == 0)
            return head;
        head = new TreeNode(pre[0]);
        if(pre.length == 1) return head;
        int i = 0;
        for (; i < pre.length; i++) {
            if (in[i] == pre[0]) break;
        }
        int[] pre_left = new int[i], in_left = new int[i];
        int[] pre_right = new int[pre.length - i - 1],
                in_right = new int[pre.length - i - 1];
        i = 0;
        for(; i < pre.length; i++) {
            if(in[i] == pre[0]) break;
            in_left[i] = in[i];
        }
        for(int j = ++i; j < pre.length; j++) {
            in_right[j-i] = in[j];
        }
        int k = 1;
        for(; k <= in_left.length; k++) pre_left[k-1] = pre[k];
        for (; k < pre.length; k++) pre_right[k - in_left.length - 1] = pre[k];
        head.left = reConstructBinaryTree(pre_left, in_left);
        head.right = reConstructBinaryTree(pre_right, in_right);
        return head;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7}, b = {3, 2, 4, 1, 6, 5, 7};
        reConstructBinaryTree(a, b);
    }
}
