package main.java.NowCoder.NowCoderCode;

import main.java.NowCoder.NowCoderUtil.RandomListNode;

/**
 * Created by Rinchar on 2018/4/6.
 */
public class _25_Clone {
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return pHead;
        Copy(pHead);
        randomCopy(pHead);
        return split(pHead);
    }

    public static void Copy(RandomListNode pHead) {
        RandomListNode tempNode = pHead;
        while (tempNode != null) {
            RandomListNode temp = new RandomListNode(tempNode.label);
            temp.next = tempNode.next;
            tempNode.next = temp;
            tempNode = temp.next;
        }
    }

    public static void randomCopy(RandomListNode pHead) {
        RandomListNode temp = pHead;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
    }

    public static RandomListNode split(RandomListNode pHead) {
        RandomListNode clone = pHead.next, temp = pHead, temp_dup = pHead.next;
        while (temp != null) {
            temp.next = temp_dup.next;
            temp = temp.next;
            if (temp != null) {
                temp_dup.next = temp.next;
                temp_dup = temp_dup.next;
            }
        }
        return clone;
    }
}
