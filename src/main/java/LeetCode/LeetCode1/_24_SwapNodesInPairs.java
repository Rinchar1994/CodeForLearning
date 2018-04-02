package main.java.LeetCode.LeetCode1;

import main.java.LeetCode.LeetCodeUtil.ListNode;

/**
 * Created by Rinchar on 2017/10/18.
 */
public class _24_SwapNodesInPairs {
    //24. Swap Nodes in Pairs (Medium) 13.23%
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        head = new ListNode(-1);
        head.next = fast;
        slow.next = fast.next;
        fast.next = slow;
        while (slow.next != null && slow.next.next != null) {
            ListNode temp = slow.next;
            slow.next = slow.next.next;
            fast = slow.next;
            temp.next = fast.next;
            fast.next = temp;
            slow = temp;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        ListNode b = new ListNode(a);
        /*System.out.println(ListNode.printListNode(b));
        System.out.println(ListNode.printListNode(swapPairs(b)));*/
        System.out.println(swapPairs(b));
    }
}
