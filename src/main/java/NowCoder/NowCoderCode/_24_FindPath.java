package main.java.NowCoder.NowCoderCode;

import main.java.NowCoder.NowCoderUtil.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Rinchar on 2018/4/6.
 */
public class _24_FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //非递归 后序遍历
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        if (root == null) return re;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode temp = root;
        ArrayList<Integer> tempList = new ArrayList<>();
        while (temp != null || treeNodeStack.size() != 0) {
            while (temp != null) {
                treeNodeStack.push(temp);
                tempList.add(temp.val);
                target -= temp.val;
                temp = temp.left != null ? temp.left : temp.right;
            }
            temp = treeNodeStack.peek();
            if (target == 0 && temp.left == null && temp.right == null) {
                //此处add的是一个引用 所以需要new一个新的
                re.add(new ArrayList<Integer>(tempList));
            }
            treeNodeStack.pop();
            tempList.remove(tempList.size() - 1);
            target += temp.val;
            if (treeNodeStack.size() > 0 && treeNodeStack.peek().left == temp) {
                temp = treeNodeStack.peek().right;
            } else temp = null;
        }
        return re;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        a.add(b);
        b.remove(0);
        b.add(2);
        a.add(b);
        a.add(b);
    }
}
