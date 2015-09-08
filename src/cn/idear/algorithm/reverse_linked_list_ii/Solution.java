package cn.idear.algorithm.reverse_linked_list_ii;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 9/8/15.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy;
        for(int i = 1; i < m; i++){
            tail.next = head;
            tail = tail.next;
            head = head.next;
        }
        tail.next = null;
        ListNode newTail = head;
        for(int i = m ; i <= n; i++){
            ListNode next = tail.next;
            ListNode headNext = head.next;
            tail.next = head;
            head.next = next;
            head = headNext;
        }
        tail = newTail;
        for(; head != null; head = head.next){
            tail.next = head;
            tail = tail.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
