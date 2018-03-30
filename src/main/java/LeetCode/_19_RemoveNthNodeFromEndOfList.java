package main.java.LeetCode;

import main.java.LeetCodeUtil.ListNode;

import java.util.Iterator;

/**
 * Created by Rinchar on 2017/10/17.
 */
public class _19_RemoveNthNodeFromEndOfList {
    //19. Remove Nth Node From End of List (Medium) 42.09%
    public static ListNode removeNthFromEnd(ListNode head, final int n) {
        int i = 0;
        ListNode temp = head;
        while (temp != null) {
            i++;
            temp = temp.next;
        }
        if (n > i) {
            return null;
        } else if (n == i) {
            head = head.next;
            return head;
        }
        temp = head;
        for(int m = 1; m < i-n; m++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(a);
        System.out.println(head.val);
        System.out.println(ListNode.printListNode(removeNthFromEnd(head, 5)));
    }
}
