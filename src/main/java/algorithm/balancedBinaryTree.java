package main.java.algorithm;

/**
 * Created by Rinchar on 2018/4/14.
 */
class BTreeNode {
    public int val;
    public BTreeNode parent = null;
    public BTreeNode leftChild = null;
    public BTreeNode rightChild = null;

    public BTreeNode(int n) {
        this.val = n;
    }
}

public class balancedBinaryTree {
    public static boolean insertTree(BTreeNode Root, int e) {
        BTreeNode target = new BTreeNode(e);
        BTreeNode temp = Root;
        if (Root == null) {
            Root = target;
            return true;
        }
        BTreeNode temp_old = temp;
        while (temp != null) {
            temp_old = temp;
            if (temp.val < e) temp = temp.rightChild;
            else if (temp.val > e) temp = temp.leftChild;
            else return false;
        }
        if (temp_old.val > e) temp_old.leftChild = target;
        else temp_old.rightChild = target;
        target.parent = temp_old;
        keepBalance(Root, temp_old);
        return true;
    }

    public static void keepBalance(BTreeNode Root, BTreeNode check) {
        int left, right, diff;
        while (check != null) {
            left = getDepth(check.leftChild);
            right = getDepth(check.rightChild);
            diff = left - right;
            if (diff > 1 || diff < -1) {
                if (diff > 1) {
                    if (getDepth(check.leftChild.leftChild) > getDepth(check.leftChild.rightChild)) {
                        LL_Rotate(Root, check);
                    } else {
                        RR_Rotate(Root, check.leftChild);
                        LL_Rotate(Root, check);
                    }
                } else {
                    if (getDepth(check.rightChild.rightChild) > getDepth(check.rightChild.leftChild)) {
                        RR_Rotate(Root, check);
                    } else {
                        LL_Rotate(Root, check.rightChild);
                        RR_Rotate(Root, check);
                    }
                }
                break;
            } else check = check.parent;
        }
    }

    public static int getDepth(BTreeNode Root) {
        if (Root == null) return 0;
        int left = getDepth(Root.leftChild);
        int right = getDepth(Root.rightChild);
        return left > right ? left + 1 : right + 1;
    }

    public static void LL_Rotate(BTreeNode Root, BTreeNode rotate) {
        BTreeNode temp = rotate.leftChild;
        if (rotate.parent != null) {
            if (rotate.parent.leftChild == rotate) rotate.parent.leftChild = temp;
            else rotate.parent.rightChild = temp;
        } else Root = temp;
        temp.parent = rotate.parent;
        rotate.leftChild = temp.rightChild;
        temp.rightChild = rotate;
    }

    public static void RR_Rotate(BTreeNode Root, BTreeNode rotate) {
        BTreeNode temp = rotate.rightChild;
        if (rotate.parent != null) {
            if (rotate.parent.leftChild == rotate) rotate.parent.leftChild = temp;
            else rotate.parent.rightChild = temp;
        } else Root = temp;
        temp.parent = rotate.parent;
        rotate.parent = temp;
        rotate.rightChild = temp.leftChild;
        temp.leftChild = rotate;
    }
}
