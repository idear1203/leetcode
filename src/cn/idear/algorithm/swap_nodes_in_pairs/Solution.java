package cn.idear.algorithm.swap_nodes_in_pairs;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 8/26/15.
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        else if(head.next.next == null){
            ListNode next = head.next;
            next.next = head;
            head.next = null;
            return next;
        }else{
            ListNode next = head.next;
            ListNode newHead = swapPairs(head.next.next);
            next.next = head;
            head.next = newHead;
            return next;
        }
    }
}
