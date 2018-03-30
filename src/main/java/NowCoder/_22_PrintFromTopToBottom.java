package main.java.NowCoder;

import main.java.NowCoderUtil.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Rinchar on 2018/3/16.
 */
public class _22_PrintFromTopToBottom {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        nodeQueue.add(root);
        while (nodeQueue.size() > 0) {
            TreeNode temp = nodeQueue.peek();
            if(temp.left != null) nodeQueue.add(temp.left);
            if(temp.right != null) nodeQueue.add(temp.right);
            result.add(temp.val);
            nodeQueue.poll();
        }
        return result;
    }
}
