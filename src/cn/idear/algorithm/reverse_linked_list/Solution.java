package cn.idear.algorithm.reverse_linked_list;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 8/25/15.
 * Reverse a singly linked list.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
