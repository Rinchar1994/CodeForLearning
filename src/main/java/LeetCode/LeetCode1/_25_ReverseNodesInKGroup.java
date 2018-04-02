package main.java.LeetCode.LeetCode1;

import main.java.LeetCode.LeetCodeUtil.ListNode;

/**
 * Created by Rinchar on 2017/10/19.
 */
public class _25_ReverseNodesInKGroup {
    //25. Reverse Nodes in k-Group (Hard) 31.15%
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode Head = new ListNode(0);
        Head.next = head;
        ListNode slow = Head, fast = Head;
        while (fast != null) {
            int i = 0;
            for(; i < k; i++) {
                if (fast.next == null) {
                    break;
                }
                fast = fast.next;
            }
            if (i != k) {
                break;
            }
            fast = fast.next;
            slow = reverse(slow, fast);
            fast = slow;
        }
        return Head.next;
    }

    public static ListNode reverse(ListNode begin, ListNode end) {
        ListNode prev = begin;
        ListNode curr = begin.next, next, first = begin.next;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode a = new ListNode(arr);
        System.out.println(ListNode.printListNode(reverseKGroup(a, 2)));
    }
}
