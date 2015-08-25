package cn.idear.algorithm.remove_nth_node_from_end_of_list;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 8/25/15.
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * slow指向待删结点的上一个结点。
         * fast - slow = n;
         */
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 1; i < n ; i++){
            fast = fast.next;
        }
        if(fast.next == null)
            return head.next;
        fast = fast.next;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
