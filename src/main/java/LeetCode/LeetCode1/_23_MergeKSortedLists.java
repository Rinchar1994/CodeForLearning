package main.java.LeetCode.LeetCode1;

import main.java.LeetCode.LeetCodeUtil.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2017/10/18.
 */
public class _23_MergeKSortedLists {
    //23. Merge k Sorted Lists (Hard) 68.75%
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> ls = new ArrayList<>();
        for (ListNode key : lists) {
            if(key != null) ls.add(key);
        }
        if(ls.size() == 0) return null;
        while (ls.size() > 1) {
            ls = mergeHalfLists(ls);
        }
        return ls.get(0);
    }

    public List<ListNode> mergeHalfLists(List<ListNode> lists) {
        int head = 0, tail = lists.size() - 1;
        while (head < tail) {
            lists.set(head, _21_MergeTwoSortedLists.mergeTwoLists(lists.get(head), lists.get(tail)));
            lists.remove(tail);
            head++;
            tail--;
        }
        return lists;
    }


    public static void main(String[] args) {
        _23_MergeKSortedLists test = new _23_MergeKSortedLists();
        ListNode[] a = new ListNode[2];
        a[0] = new ListNode(1);
        a[1] = new ListNode(0);
        System.out.println(test.mergeKLists(a));
    }
}
