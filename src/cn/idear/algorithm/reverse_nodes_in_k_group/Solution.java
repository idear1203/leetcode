package cn.idear.algorithm.reverse_nodes_in_k_group;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 8/26/15.
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1)
            return head;
        ListNode nextK = findNextK(head, k);
        if(nextK != null){
            ListNode nextPart = reverseKGroup(nextK.next, k);
            reverseList(head, nextK);
            head.next = nextPart;
            return nextK;
        }else{
            return head;
        }
    }

    private void reverseList(ListNode head, ListNode nextK) {
        if(head != nextK){
            ListNode next = head.next;
            reverseList(next, nextK);
            next.next = head;
            head.next = null;
        }
    }

    private ListNode findNextK(ListNode head, int k) {
        ListNode curNode = head;
        for(int i = 0; i < k - 1 && curNode != null; i++){
           curNode = curNode.next;
        }
        return curNode;
    }
}
