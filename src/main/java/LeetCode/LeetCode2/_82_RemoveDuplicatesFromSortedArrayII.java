package main.java.LeetCode.LeetCode2;

import main.java.LeetCode.LeetCodeUtil.ListNode;

/**
 * Created by Rinchar on 2017/11/15.
 */
public class _82_RemoveDuplicatesFromSortedArrayII {
    //82. Remove Duplicates from Sorted Array II (Medium) 14.81%
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode point = head, beginNode = new ListNode(-1);
        beginNode.next = head;
        ListNode begin = beginNode;
        if (head == null) return head;
        boolean isDup = false;
        while (point != null) {
            if (point.next != null) {
                if (point.val == point.next.val) {
                    point.next = point.next.next;
                    isDup = true;
                } else {
                    if (isDup) {
                        begin.next = point.next;
                        point = begin.next;
                        isDup = false;
                    } else {
                        begin = point;
                        point = point.next;
                    }
                }
            } else {
                if (isDup) begin.next = null;
                point = point.next;
            }
        }
        return beginNode.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        ListNode b = new ListNode(a);
        System.out.println(deleteDuplicates(b).toString());
    }
}
