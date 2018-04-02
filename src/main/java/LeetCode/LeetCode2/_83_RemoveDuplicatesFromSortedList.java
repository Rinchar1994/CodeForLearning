package main.java.LeetCode.LeetCode2;

import main.java.LeetCode.LeetCodeUtil.ListNode;

/**
 * Created by Rinchar on 2017/11/8.
 */
public class _83_RemoveDuplicatesFromSortedList {
    //83. Remove Duplicates from Sorted List (Easy) 10.95%
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode slow = head, fast = head;
        while (slow != null) {
            fast = slow.next;
            if (fast == null) return head;
            if (fast.val == slow.val) {
                slow.next = fast.next;
            } else {
                slow = fast;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 3};
        ListNode head = new ListNode(a);
        System.out.println(ListNode.printListNode(deleteDuplicates(head)));
    }
}
