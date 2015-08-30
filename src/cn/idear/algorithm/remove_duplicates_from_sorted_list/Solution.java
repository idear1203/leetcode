package cn.idear.algorithm.remove_duplicates_from_sorted_list;

import cn.idear.algorithm.util.ListNode;

/**
 * Created by wangdongwei on 8/30/15.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode tailNode = head;
        for(ListNode curNode = head.next; curNode != null; curNode = curNode.next)
            if(curNode.val != tailNode.val){
                tailNode.next = curNode;
                tailNode = tailNode.next;
            }
        tailNode.next = null;
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        for(ListNode prevNode = head, curNode = head.next; curNode != null; curNode = curNode.next){
            if(curNode.val == prevNode.val){
                prevNode.next = curNode.next;
            }else{
                prevNode = prevNode.next;
            }
        }
        return head;
    }
}
