package main.java.NowCoder.NowCoderCode;

import main.java.NowCoder.NowCoderUtil.ListNode;

/**
 * Created by Rinchar on 2018/3/13.
 */
public class _14_FindKthToTail {
    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        p = head;
        if(k > len) return null;
        k = len - k + 1;
        while (--k > 0) {
            p = p.next;
        }
        return p;
    }
}
