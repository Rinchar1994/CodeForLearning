package main.java.LeetCode;

import main.java.LeetCodeUtil.ListNode;

/**
 * Created by Rinchar on 2017/9/29.
 */
public class _2_AddTwoNumbers {
    //2. Add Two Numbers (Medium)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode((l1.val + l2.val) % 10);
        ListNode Head = l3;
        int carry = (l1.val + l2.val) / 10;
        while (l1.next != null || l2.next != null || carry != 0) {
            if (l1.next != null) {
                l1 = l1.next;
                carry += l1.val;
            }
            if (l2.next != null) {
                l2 = l2.next;
                carry += l2.val;
            }
            l3.next = new ListNode(carry % 10);
            carry /= 10;
            l3 = l3.next;
        }
        return Head;
    }
}
