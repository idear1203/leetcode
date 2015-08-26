package cn.idear.algorithm.remove_linked_list_elements;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 8/26/15.
 * Remove all elements from a linked list of integers that have value val.
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        for(ListNode curNode = head; curNode != null; curNode = curNode.next){
            if(curNode.val == val){
                prev.next = curNode.next;
            }else{
                prev = curNode;
            }
        }
        return dummy.next;
    }
}
