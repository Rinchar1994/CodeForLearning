package main.java.LeetCode.LeetCode1;

import main.java.LeetCode.LeetCodeUtil.ListNode;

/**
 * Created by Rinchar on 2017/10/17.
 */
public class _21_MergeTwoSortedLists {
    //21. Merge Two Sorted Lists (Easy) 48.27%
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode head1 = new ListNode(0), head2 = new ListNode(0);
        head1.next = l1;
        head2.next = l2;
        ListNode po = head1;
        while (true) {
            if (po.next.val < head2.next.val) {
                if (po.next.next == null) {
                    po.next.next = head2.next;
                    return head1.next;
                }
                po = po.next;
            } else {
                ListNode temp = head2.next.next;
                head2.next.next = po.next;
                po.next = head2.next;
                if (temp == null) return head1.next;
                head2.next = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};
        ListNode l1 = new ListNode(a), l2 = new ListNode(b);
        System.out.println(ListNode.printListNode(mergeTwoLists(l1, l2)));
    }
}
