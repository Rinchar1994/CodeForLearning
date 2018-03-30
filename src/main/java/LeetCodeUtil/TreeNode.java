package main.java.LeetCodeUtil;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Rinchar on 2017/10/26.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    //Integer.MIN_VALUE表示null
    public void initialTreeNode(int[] arr) {
        if (arr.length == 0) return;
        this.val = arr[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        int pos = 0;
        while (!queue.isEmpty()) {
            if (++pos >= arr.length) return;
            TreeNode temp = queue.peek();
            queue.poll();
            if (arr[pos] != Integer.MIN_VALUE) {
                temp.left = new TreeNode(arr[pos]);
                queue.add(temp.left);
            }
            if (++pos >= arr.length) return;
            if (arr[pos] != Integer.MIN_VALUE) {
                temp.right = new TreeNode(arr[pos]);
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 2};
        TreeNode b = new TreeNode(-1);
        b.initialTreeNode(a);
        System.out.println(b.right.left.val);
    }
}
