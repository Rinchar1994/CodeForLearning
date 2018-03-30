package main.java.NowCoder;

import main.java.NowCoderUtil.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2018/3/8.
 */
public class _3_PrintListFromTailToHead {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> reverse = new ArrayList<>();
        while (listNode != null) {
            reverse.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = reverse.size() - 1; i >= 0; i--) {
            result.add(reverse.get(i));
        }
        return result;
    }
}
