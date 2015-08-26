package cn.idear.algorithm.delete_node_in_a_linked_list;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 8/26/15.
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = node;
        for(ListNode curNode = node; curNode.next != null; curNode = curNode.next){
            curNode.val = curNode.next.val;
            prev = prev.next;
        }
        prev.next = null;
    }
}
