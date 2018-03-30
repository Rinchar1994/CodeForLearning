package main.java.LeetCode2;

import main.java.LeetCodeUtil.ListNode;

/**
 * Created by Rinchar on 2017/11/5.
 */
public class _61_RotateList {
    //61. Rotate List (Medium) 53.31%
    public static ListNode rotateRight(ListNode head, int k) {
        int cnt = 0;
        if(head == null) return head;
        ListNode p = head;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        k %= cnt;
        if (k == 0) return head;
        p = head;
        for (; cnt > k + 1; cnt--) {
            p = p.next;
        }
        ListNode q = p;
        while(q.next != null) q = q.next;
        q.next = head;
        head = p.next;
        p.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode b = rotateRight(new ListNode(a), 2);
        System.out.println(ListNode.printListNode(b));
    }
}
