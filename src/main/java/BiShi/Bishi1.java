package main.java.BiShi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: Rinchar
 * @date: 2018/9/16
 **/
class TreeNode{
    int data;
    TreeNode lChild;
    TreeNode rChild;

    public TreeNode(int data) {
        this.data = data;
        this.lChild = null;
        this.rChild = null;
    }
}
public class Bishi1 {

    //层次-中序二叉树还原
    private static TreeNode Lev_Mid_Restore(int[] lev, int[] mid) {
        final int size = lev.length;
        TreeNode[] helper = new TreeNode[size];
        for(int i = 0; i < size; i++)
            helper[i] = new TreeNode(0);
        boolean success = false;

        TreeNode result = new TreeNode(lev[0]);
        int mi = find(mid, lev[0]);
        helper[mi] = result;

        for(int i = 1; i < lev.length; i++) {
            success = false;
            mi = find(mid, lev[i]);
            helper[mi] = new TreeNode(lev[i]);
            for(int p = mi - 1; p >= 0; p--) {
                if(helper[p] != null && helper[p].data != 0) {
                    if(helper[p].rChild == null || helper[p].rChild.data == 0) {
                        helper[p].rChild = helper[mi];
                        success = true;
                    }
                    break;
                }
            }
            if(success) {
                continue;
            }
            for(int p = mi + 1; p < size; p++) {
                if(helper[p] != null && helper[p].data != 0) {
                    if(helper[p].lChild == null || helper[p].lChild.data == 0) {
                        helper[p].lChild = helper[mi];
                        success = true;
                    }
                    break;
                }
            }
        }
        return result;
    }

    private static int find(int[] arr, int tar) {
        for (int i = 0; i < arr.length; i++) {
            if (tar == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String levelStr = in.nextLine();
        String midStr = in.nextLine();
        String[] levelStrs = levelStr.trim().split(" ");
        String[] midStrs = midStr.trim().split(" ");
        int[] Levorder1 = new int[levelStrs.length];
        int[] Midorder1 = new int[midStrs.length];
        for (int i = 0; i < levelStrs.length; i++) {
            Levorder1[i] = Integer.valueOf(levelStrs[i]);
            Midorder1[i] = Integer.valueOf(midStrs[i]);
        }
        TreeNode head = Lev_Mid_Restore(Levorder1, Midorder1);

        leafPrint(head);

        prePrint(head);

        StringBuilder postbuilder = new StringBuilder();
        postPrint(head, postbuilder);
        System.out.println(postbuilder.toString().trim());
    }

    private static void leafPrint(TreeNode Head) {
        TreeNode node = Head;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        StringBuilder leaf = new StringBuilder();
        while (node != null || !treeNodeStack.isEmpty()) {
            if (node != null) {
                treeNodeStack.push(node);
                if (node.rChild == null && node.lChild == null) {
                    leaf.append(node.data);
                    leaf.append(" ");
                }
                node = node.lChild;
            } else {
                node = treeNodeStack.peek();
                treeNodeStack.pop();
                node = node.rChild;
            }
        }
        System.out.println(leaf.toString().trim());
    }

    private static void prePrint(TreeNode Head) {
        TreeNode node = Head;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        StringBuilder re = new StringBuilder();
        while (node != null || !treeNodeStack.isEmpty()) {
            if (node != null) {
                treeNodeStack.push(node);
                re.append(node.data);
                re.append(" ");
                node = node.lChild;
            } else {
                node = treeNodeStack.peek();
                treeNodeStack.pop();
                node = node.rChild;
            }
        }
        System.out.println(re.toString().trim());
    }

    private static void postPrint(TreeNode Head, StringBuilder stringBuilder) {
        if (Head == null) {
            return;
        }
        if (Head.lChild != null) {
            postPrint(Head.lChild, stringBuilder);
        }
        if (Head.rChild != null) {
            postPrint(Head.rChild, stringBuilder);
        }
        stringBuilder.append(Head.data);
        stringBuilder.append(" ");
    }
}