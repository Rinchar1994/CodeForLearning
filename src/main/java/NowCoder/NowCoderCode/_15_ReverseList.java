package main.java.NowCoder.NowCoderCode;

import main.java.NowCoder.NowCoderUtil.ListNode;

/**
 * Created by Rinchar on 2018/3/13.
 */
public class _15_ReverseList {
    public static ListNode ReverseList(ListNode head) {
        if(head == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            slow.next = fast.next;
            fast.next = head;
            head = fast;
            fast = slow.next;
        }
        return head;
    }
}
