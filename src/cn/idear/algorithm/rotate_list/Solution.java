package cn.idear.algorithm.rotate_list;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 8/29/15.
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int length = 1;
        ListNode tailNode;
        for(tailNode = head; tailNode.next != null; tailNode = tailNode.next)
            length++;
        k = k % length;
        if(k > 0){
            ListNode node = findNthNode(dummy, length - k);
            tailNode.next = head;
            dummy.next = node.next;
            node.next = null;
        }
        return dummy.next;
    }

    private ListNode findNthNode(ListNode head, int n) {
        ListNode node = head;
        for(int i = 0; i < n; i++)
            node = node.next;
        return node;
    }
}
