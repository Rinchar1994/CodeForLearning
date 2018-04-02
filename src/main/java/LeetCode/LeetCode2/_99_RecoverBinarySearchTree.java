package main.java.LeetCode.LeetCode2;

import main.java.LeetCode.LeetCodeUtil.TreeNode;

/**
 * Created by Rinchar on 2017/11/11.
 */
public class _99_RecoverBinarySearchTree {
    //99. Recover Binary Search Tree (Hard) Not work out!!!!
    static TreeNode firstElement = null;
    static TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    static TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public static void recoverTree(TreeNode root) {

        // In order traversal to find the two elements
        traverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private static void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;

        // End of "do some business"

        traverse(root.right);
    }

    public static void main(String[] args) {
        int[] a = {2, 3, Integer.MIN_VALUE, 1, Integer.MIN_VALUE, Integer.MIN_VALUE, 4};
        TreeNode b = new TreeNode(-1);
        b.initialTreeNode(a);
        recoverTree(b);
    }
}
