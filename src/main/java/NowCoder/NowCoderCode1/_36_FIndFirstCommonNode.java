package main.java.NowCoder.NowCoderCode1;

import main.java.NowCoder.NowCoderUtil.ListNode;

/**
 * Created by Rinchar on 2018/4/30.
 */
public class _36_FIndFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        int len1 = 1, len2 = 1;
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1.next != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2.next != null) {
            len2++;
            p2 = p2.next;
        }
        if (p1 != p2) {
            return null;
        } else {
            p1 = pHead1;
            p2 = pHead2;
            if (len1 > len2)
                for (int i = 0; i < len1 - len2; i++)
                    p1 = p1.next;
            else
                for (int i = 0; i < len2 - len1; i++)
                    p2 = p2.next;
            while (p1 != null) {
                if (p1 == p2) return p1;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return null;
    }
}
