package main.java.LeetCode.LeetCodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2017/9/29.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] list) {
        if (list.length == 0) {
            return;
        }
        this.val = list[0];
        ListNode po = this;
        for(int i = 1; i < list.length; i++) {
            po.next = new ListNode(list[i]);
            po = po.next;
        }
    }

    public static List<Integer> printListNode(ListNode listNode) {
        List<Integer> re = new ArrayList<>();
        while (listNode != null) {
            re.add(listNode.val);
            listNode = listNode.next;
        }
        return re;
    }

    public String toString(){
        if(this == null) return "";
        String re = Integer.toString(this.val);
        ListNode temp = this.next;
        while (temp != null) {
            re += "->" + Integer.toString(temp.val);
            temp = temp.next;
        }
        return re;
    }
}
