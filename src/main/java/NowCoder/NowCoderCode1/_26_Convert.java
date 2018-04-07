package main.java.NowCoder.NowCoderCode1;

import main.java.NowCoder.NowCoderUtil.TreeNode;

import java.util.Stack;

/**
 * Created by Rinchar on 2018/4/7.
 */
public class _26_Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return pRootOfTree;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode temp = pRootOfTree, tempList = null;
        while (temp != null || !treeNodeStack.empty()) {
            if (temp != null) {
                treeNodeStack.push(temp);
                temp = temp.left;
            } else {
                temp = treeNodeStack.peek();
                treeNodeStack.pop();
                if (tempList == null) {
                    tempList = temp;
                    tempList.left = null;
                } else {
                    tempList.right = temp;
                    temp.left = tempList;
                    tempList = temp;
                }
                temp = temp.right;
            }
        }
        tempList.right = null;
        while (tempList.left != null) {
            tempList = tempList.left;
        }
        return tempList;
    }
}
