package main.java.NowCoder.NowCoderCode;

import main.java.NowCoder.NowCoderUtil.ListNode;

/**
 * Created by Rinchar on 2018/3/13.
 */
public class _14_FindKthToTail {
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode slow = head, fast = head;
        for (int i = 0; i < k - 1; i++) {
            if (fast.next == null) return null;
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
