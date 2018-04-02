package main.java.NowCoder.NowCoderCode;

import main.java.NowCoder.NowCoderUtil.ListNode;

/**
 * Created by Rinchar on 2018/3/14.
 */
public class _16_Merge {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2, head = null, p = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (head == null) {
                    p = list1;
                    head = list1;
                } else {
                    p.next = list1;
                    p = p.next;
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    p = list2;
                    head = list2;
                } else {
                    p.next = list2;
                    p = p.next;
                }
                list2 = list2.next;
            }
        }
        if (p == null) return list1 == null ? list2 : list1;
        p.next = list1 == null ? list2 : list1;
        return head;
    }
}
